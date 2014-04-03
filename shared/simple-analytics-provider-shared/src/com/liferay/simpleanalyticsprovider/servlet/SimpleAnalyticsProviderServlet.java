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

package com.liferay.simpleanalyticsprovider.servlet;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.util.AnonymousUsersManager;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class SimpleAnalyticsProviderServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		try {
			if (_anonymousUsersManager == null) {
				_intiAnonymousUserManager();
			}

			AnonymousUser anonymousUser =
				_anonymousUsersManager.getAnonymousUser(request, response);

			Message message = new Message();

			message.put("anonymousUserId", anonymousUser.getAnonymousUserId());

			MessageBusUtil.sendMessage("liferay/analytics", message);
		}
		catch (Exception e) {
			_log.error(e, e);

			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);
		}
	}

	private void _intiAnonymousUserManager() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_anonymousUsersManager = ServiceTrackerUtil.getService(
			AnonymousUsersManager.class, bundle.getBundleContext());
	}

	private static Log _log = LogFactoryUtil.getLog(
		SimpleAnalyticsProviderServlet.class);

	private AnonymousUsersManager _anonymousUsersManager;

}