/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.contenttargeting.portlet;

import aQute.bnd.annotation.component.Reference;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.portlet.internal.RulesRegistryFactory;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.contenttargeting.service.UserSegmentServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Eduardo Garcia
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	private UserSegmentService _userSegmentService;

	@Reference
	public void setUserSegmentService(
		UserSegmentService userSegmentService) {

		_userSegmentService = userSegmentService;
	}

	public void addUserSegment(ActionRequest request, ActionResponse response)
		throws Exception {

		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		try {
			_userSegmentService.addUserSegment(
				name, description, serviceContext);

			String redirect = ParamUtil.getString(request, "redirect");

			response.sendRedirect(redirect);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			if (e instanceof PrincipalException) {
				response.setRenderParameter(
					"mvcPath", "/html/user_segment/edit_user_segment.ftl");
			}
			else {
				response.setRenderParameter("mvcPath", "/error.ftl");
			}
		}
	}

	private RulesRegistry _rulesRegistry =
		RulesRegistryFactory.getRulesRegistryFactory();

}