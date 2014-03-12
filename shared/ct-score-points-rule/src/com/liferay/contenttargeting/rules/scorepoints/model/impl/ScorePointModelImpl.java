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

package com.liferay.contenttargeting.rules.scorepoints.model.impl;

import com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint;
import com.liferay.contenttargeting.rules.scorepoints.model.ScorePointModel;
import com.liferay.contenttargeting.rules.scorepoints.model.ScorePointSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ScorePoint service. Represents a row in the &quot;ScorePoints_ScorePoint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.contenttargeting.rules.scorepoints.model.ScorePointModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScorePointImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointImpl
 * @see com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint
 * @see com.liferay.contenttargeting.rules.scorepoints.model.ScorePointModel
 * @generated
 */
@JSON(strict = true)
public class ScorePointModelImpl extends BaseModelImpl<ScorePoint>
	implements ScorePointModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a score point model instance should use the {@link com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint} interface instead.
	 */
	public static final String TABLE_NAME = "ScorePoints_ScorePoint";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "Id", Types.BIGINT },
			{ "anonymousUserId", Types.BIGINT },
			{ "userSegmentId", Types.BIGINT },
			{ "points", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ScorePoints_ScorePoint (uuid_ VARCHAR(75) null,Id LONG not null primary key,anonymousUserId LONG,userSegmentId LONG,points LONG)";
	public static final String TABLE_SQL_DROP = "drop table ScorePoints_ScorePoint";
	public static final String ORDER_BY_JPQL = " ORDER BY scorePoint.anonymousUserId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ScorePoints_ScorePoint.anonymousUserId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint"),
			true);
	public static long ANONYMOUSUSERID_COLUMN_BITMASK = 1L;
	public static long USERSEGMENTID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ScorePoint toModel(ScorePointSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ScorePoint model = new ScorePointImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setAnonymousUserId(soapModel.getAnonymousUserId());
		model.setUserSegmentId(soapModel.getUserSegmentId());
		model.setPoints(soapModel.getPoints());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ScorePoint> toModels(ScorePointSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ScorePoint> models = new ArrayList<ScorePoint>(soapModels.length);

		for (ScorePointSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint"));

	public ScorePointModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ScorePoint.class;
	}

	@Override
	public String getModelClassName() {
		return ScorePoint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Id", getId());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("points", getPoints());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long points = (Long)attributes.get("points");

		if (points != null) {
			setPoints(points);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _Id;
	}

	@Override
	public void setId(long Id) {
		_Id = Id;
	}

	@JSON
	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_columnBitmask = -1L;

		if (!_setOriginalAnonymousUserId) {
			_setOriginalAnonymousUserId = true;

			_originalAnonymousUserId = _anonymousUserId;
		}

		_anonymousUserId = anonymousUserId;
	}

	@Override
	public String getAnonymousUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAnonymousUserId(), "uuid",
			_anonymousUserUuid);
	}

	@Override
	public void setAnonymousUserUuid(String anonymousUserUuid) {
		_anonymousUserUuid = anonymousUserUuid;
	}

	public long getOriginalAnonymousUserId() {
		return _originalAnonymousUserId;
	}

	@JSON
	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_columnBitmask |= USERSEGMENTID_COLUMN_BITMASK;

		if (!_setOriginalUserSegmentId) {
			_setOriginalUserSegmentId = true;

			_originalUserSegmentId = _userSegmentId;
		}

		_userSegmentId = userSegmentId;
	}

	public long getOriginalUserSegmentId() {
		return _originalUserSegmentId;
	}

	@JSON
	@Override
	public long getPoints() {
		return _points;
	}

	@Override
	public void setPoints(long points) {
		_points = points;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ScorePoint.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ScorePoint toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ScorePoint)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScorePointImpl scorePointImpl = new ScorePointImpl();

		scorePointImpl.setUuid(getUuid());
		scorePointImpl.setId(getId());
		scorePointImpl.setAnonymousUserId(getAnonymousUserId());
		scorePointImpl.setUserSegmentId(getUserSegmentId());
		scorePointImpl.setPoints(getPoints());

		scorePointImpl.resetOriginalValues();

		return scorePointImpl;
	}

	@Override
	public int compareTo(ScorePoint scorePoint) {
		int value = 0;

		if (getAnonymousUserId() < scorePoint.getAnonymousUserId()) {
			value = -1;
		}
		else if (getAnonymousUserId() > scorePoint.getAnonymousUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScorePoint)) {
			return false;
		}

		ScorePoint scorePoint = (ScorePoint)obj;

		long primaryKey = scorePoint.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ScorePointModelImpl scorePointModelImpl = this;

		scorePointModelImpl._originalUuid = scorePointModelImpl._uuid;

		scorePointModelImpl._originalAnonymousUserId = scorePointModelImpl._anonymousUserId;

		scorePointModelImpl._setOriginalAnonymousUserId = false;

		scorePointModelImpl._originalUserSegmentId = scorePointModelImpl._userSegmentId;

		scorePointModelImpl._setOriginalUserSegmentId = false;

		scorePointModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ScorePoint> toCacheModel() {
		ScorePointCacheModel scorePointCacheModel = new ScorePointCacheModel();

		scorePointCacheModel.uuid = getUuid();

		String uuid = scorePointCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			scorePointCacheModel.uuid = null;
		}

		scorePointCacheModel.Id = getId();

		scorePointCacheModel.anonymousUserId = getAnonymousUserId();

		scorePointCacheModel.userSegmentId = getUserSegmentId();

		scorePointCacheModel.points = getPoints();

		return scorePointCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", Id=");
		sb.append(getId());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", points=");
		sb.append(getPoints());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>points</column-name><column-value><![CDATA[");
		sb.append(getPoints());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ScorePoint.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ScorePoint.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _Id;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private long _originalAnonymousUserId;
	private boolean _setOriginalAnonymousUserId;
	private long _userSegmentId;
	private long _originalUserSegmentId;
	private boolean _setOriginalUserSegmentId;
	private long _points;
	private long _columnBitmask;
	private ScorePoint _escapedModel;
}