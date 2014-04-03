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

package com.liferay.analytics.api;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Deactivate;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.ResourceActionsUtil;

import java.util.Locale;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseAnalyticsProvider implements AnalyticsProvider {

	@Activate
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Analytics Provider activate: " + getAnalyticsProviderId());
		}
	}

	@Deactivate
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Analytics Provider deactivate: " + getAnalyticsProviderId());
		}
	}

	@Override
	public String getAnalyticsProviderId() {
		return getClass().getSimpleName();
	}

	@Override
	public String getName(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, getClass().getName());
	}

	private static Log _log = LogFactoryUtil.getLog(
		BaseAnalyticsProvider.class);

}