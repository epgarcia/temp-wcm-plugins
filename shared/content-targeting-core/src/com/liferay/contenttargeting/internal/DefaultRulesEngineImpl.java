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

package com.liferay.contenttargeting.internal;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesEngine;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Julio Camarero
 */
@Component
public class DefaultRulesEngineImpl implements RulesEngine {

	@Activate
	public void activate() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, bundle.getBundleContext());
	}

	@Override
	public boolean matches(
		AnonymousUser anonymousUser, List<RuleInstance> ruleInstances) {

		for (RuleInstance ruleInstance : ruleInstances) {
			Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

			if (rule == null) {
				continue;
			}

			try {
				if (!rule.evaluate(ruleInstance, anonymousUser)) {
					return false;
				}
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Couldn't evaluate Rule " + ruleInstance.getRuleKey());
				}

				return false;
			}
		}

		return true;
	}

	private static Log _log = LogFactoryUtil.getLog(
		DefaultRulesEngineImpl.class);

	private RulesRegistry _rulesRegistry;

}