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

import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.portlet.internal.ComponentsRegistryFactory;
import com.liferay.contenttargeting.service.UserSegmentService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.freemarker.FreeMarkerPortlet;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.UnavailableException;

/**
 * @author Eduardo Garcia
 * @author Carlos Sierra Andrés
 *
 */
public class ContentTargetingPortlet extends FreeMarkerPortlet {

	@Override
	public void init() throws PortletException {
		super.init();

		PortletContext portletContext = getPortletContext();

		Bundle bundle = (Bundle)portletContext.getAttribute("OSGI_BUNDLE");

		if (bundle == null) {
			throw new UnavailableException(
				"Can't find a reference to the OSGi bundle") {

				@Override
				public boolean isPermanent() {
					return true;
				}
			};
		}

		final BundleContext bundleContext = bundle.getBundleContext();

		_userSegmentServiceTracker =
			new ServiceTracker<UserSegmentService, UserSegmentService>(
				bundleContext, UserSegmentService.class, null);
		
		_userSegmentServiceTracker.open();

		try {
			UserSegmentService userSegmentService = _userSegmentServiceTracker.
				waitForService(5 * 1000);

			if (userSegmentService == null) {
				throw new UnavailableException(_UNAVAILABLE_SERVICE_TEXT, 0);
			}

		} catch (InterruptedException e) {
			throw new UnavailableException(_UNAVAILABLE_SERVICE_TEXT, 0);
		}
	}

	public void addUserSegment(ActionRequest request, ActionResponse response)
		throws Exception {

		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			UserSegment.class.getName(), request);

		try {
			UserSegmentService userSegmentService =
				_userSegmentServiceTracker.getService();

			if (userSegmentService == null) {
				throw new UnavailableException(_UNAVAILABLE_SERVICE_TEXT, 0);
			}

			userSegmentService.addUserSegment(
				name, description, serviceContext);

			String redirect = ParamUtil.getString(request, "redirect");

			//response.sendRedirect(redirect);
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

			e.printStackTrace();
		}
	}

	private ServiceTracker<UserSegmentService, UserSegmentService>
		_userSegmentServiceTracker;

	private static final String _UNAVAILABLE_SERVICE_TEXT =
		"Can't find a reference to " + UserSegmentService.class;

}