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

package com.liferay.analytics.impl;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.liferay.analytics.api.AnalyticsProvider;
import com.liferay.analytics.api.AnalyticsProvidersRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eduardo Garcia
 */
@Component
public class DefaultAnalyticsProvidersRegistryImpl
	implements AnalyticsProvidersRegistry {

	@Override
	public AnalyticsProvider getAnalyticsProvider(String analyticsProviderId) {
		return _analyticsProviders.get(analyticsProviderId);
	}

	@Override
	public Map<String, AnalyticsProvider> getAnalyticsProviders() {
		return _analyticsProviders;
	}

	@Reference(type = '*', unbind = "unregisterAnalyticsProvider")
	public void registerAnalyticsProvider(AnalyticsProvider analyticsProvider) {
		_analyticsProviders.put(
			analyticsProvider.getAnalyticsProviderId(), analyticsProvider);
	}

	public void unregisterAnalyticsProvider(
		AnalyticsProvider analyticsProvider) {

		_analyticsProviders.remove(analyticsProvider);
	}

	private Map<String, AnalyticsProvider> _analyticsProviders =
		new ConcurrentHashMap<String, AnalyticsProvider>();

}