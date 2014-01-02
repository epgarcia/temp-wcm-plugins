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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSegmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentLocalService
 * @generated
 */
public class UserSegmentLocalServiceWrapper implements UserSegmentLocalService,
	ServiceWrapper<UserSegmentLocalService> {
	public UserSegmentLocalServiceWrapper(
		UserSegmentLocalService userSegmentLocalService) {
		_userSegmentLocalService = userSegmentLocalService;
	}

	/**
	* Adds the user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment addUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.addUserSegment(userSegment);
	}

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param segmentId the primary key for the new user segment
	* @return the new user segment
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment createUserSegment(
		long segmentId) {
		return _userSegmentLocalService.createUserSegment(segmentId);
	}

	/**
	* Deletes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws PortalException if a user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment deleteUserSegment(
		long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.deleteUserSegment(segmentId);
	}

	/**
	* Deletes the user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment deleteUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.deleteUserSegment(userSegment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userSegmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment fetchUserSegment(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.fetchUserSegment(segmentId);
	}

	/**
	* Returns the user segment with the matching UUID and company.
	*
	* @param uuid the user segment's UUID
	* @param companyId the primary key of the company
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment fetchUserSegmentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.fetchUserSegmentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment fetchUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.fetchUserSegmentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the user segment with the primary key.
	*
	* @param segmentId the primary key of the user segment
	* @return the user segment
	* @throws PortalException if a user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment getUserSegment(
		long segmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getUserSegment(segmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user segment with the matching UUID and company.
	*
	* @param uuid the user segment's UUID
	* @param companyId the primary key of the company
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment getUserSegmentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getUserSegmentByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the user segment matching the UUID and group.
	*
	* @param uuid the user segment's UUID
	* @param groupId the primary key of the group
	* @return the matching user segment
	* @throws PortalException if a matching user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment getUserSegmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getUserSegmentByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of user segments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.UserSegment> getUserSegments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getUserSegments(start, end);
	}

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserSegmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.getUserSegmentsCount();
	}

	/**
	* Updates the user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegment the user segment
	* @return the user segment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.UserSegment updateUserSegment(
		com.liferay.contenttargeting.model.UserSegment userSegment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.updateUserSegment(userSegment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userSegmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSegmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSegmentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment addUserSegment(
		long userId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.addUserSegment(userId, name,
			description, serviceContext);
	}

	@Override
	public com.liferay.contenttargeting.model.UserSegment updateUserSegment(
		long userSegmentId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentLocalService.updateUserSegment(userSegmentId, name,
			description, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserSegmentLocalService getWrappedUserSegmentLocalService() {
		return _userSegmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {
		_userSegmentLocalService = userSegmentLocalService;
	}

	@Override
	public UserSegmentLocalService getWrappedService() {
		return _userSegmentLocalService;
	}

	@Override
	public void setWrappedService(
		UserSegmentLocalService userSegmentLocalService) {
		_userSegmentLocalService = userSegmentLocalService;
	}

	private UserSegmentLocalService _userSegmentLocalService;
}