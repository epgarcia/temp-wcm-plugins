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

package com.liferay.simpleanalyticsprovider.impl;

import aQute.bnd.annotation.component.Component;

import com.liferay.analytics.api.AnalyticsProvider;
import com.liferay.analytics.api.BaseAnalyticsProvider;

import java.net.URL;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
@Component(immediate = true, provide = AnalyticsProvider.class)
public class SimpleAnalyticsProvider extends BaseAnalyticsProvider {

	@Override
	public URL getJSPath() {
		Bundle bundle = FrameworkUtil.getBundle(SimpleAnalyticsProvider.class);

		return bundle.getEntry("js/simple-analytics-provider.js");
	}

}