/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.workflow.kaleo.model;


/**
 * <a href="KaleoActionSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a wrapper for {@link KaleoAction}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoAction
 * @generated
 */
public class KaleoActionWrapper implements KaleoAction {
	public KaleoActionWrapper(KaleoAction kaleoAction) {
		_kaleoAction = kaleoAction;
	}

	public long getPrimaryKey() {
		return _kaleoAction.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_kaleoAction.setPrimaryKey(pk);
	}

	public long getKaleoActionId() {
		return _kaleoAction.getKaleoActionId();
	}

	public void setKaleoActionId(long kaleoActionId) {
		_kaleoAction.setKaleoActionId(kaleoActionId);
	}

	public long getCompanyId() {
		return _kaleoAction.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_kaleoAction.setCompanyId(companyId);
	}

	public long getUserId() {
		return _kaleoAction.getUserId();
	}

	public void setUserId(long userId) {
		_kaleoAction.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoAction.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_kaleoAction.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _kaleoAction.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_kaleoAction.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _kaleoAction.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_kaleoAction.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _kaleoAction.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_kaleoAction.setModifiedDate(modifiedDate);
	}

	public long getKaleoDefinitionId() {
		return _kaleoAction.getKaleoDefinitionId();
	}

	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_kaleoAction.setKaleoDefinitionId(kaleoDefinitionId);
	}

	public long getKaleoNodeId() {
		return _kaleoAction.getKaleoNodeId();
	}

	public void setKaleoNodeId(long kaleoNodeId) {
		_kaleoAction.setKaleoNodeId(kaleoNodeId);
	}

	public java.lang.String getKaleoNodeName() {
		return _kaleoAction.getKaleoNodeName();
	}

	public void setKaleoNodeName(java.lang.String kaleoNodeName) {
		_kaleoAction.setKaleoNodeName(kaleoNodeName);
	}

	public java.lang.String getName() {
		return _kaleoAction.getName();
	}

	public void setName(java.lang.String name) {
		_kaleoAction.setName(name);
	}

	public java.lang.String getDescription() {
		return _kaleoAction.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_kaleoAction.setDescription(description);
	}

	public java.lang.String getLanguage() {
		return _kaleoAction.getLanguage();
	}

	public void setLanguage(java.lang.String language) {
		_kaleoAction.setLanguage(language);
	}

	public java.lang.String getScript() {
		return _kaleoAction.getScript();
	}

	public void setScript(java.lang.String script) {
		_kaleoAction.setScript(script);
	}

	public java.lang.String getExecutionType() {
		return _kaleoAction.getExecutionType();
	}

	public void setExecutionType(java.lang.String executionType) {
		_kaleoAction.setExecutionType(executionType);
	}

	public int getExecutionOrder() {
		return _kaleoAction.getExecutionOrder();
	}

	public void setExecutionOrder(int executionOrder) {
		_kaleoAction.setExecutionOrder(executionOrder);
	}

	public KaleoAction toEscapedModel() {
		return _kaleoAction.toEscapedModel();
	}

	public boolean isNew() {
		return _kaleoAction.isNew();
	}

	public boolean setNew(boolean n) {
		return _kaleoAction.setNew(n);
	}

	public boolean isCachedModel() {
		return _kaleoAction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_kaleoAction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _kaleoAction.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_kaleoAction.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _kaleoAction.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kaleoAction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kaleoAction.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _kaleoAction.clone();
	}

	public int compareTo(KaleoAction kaleoAction) {
		return _kaleoAction.compareTo(kaleoAction);
	}

	public int hashCode() {
		return _kaleoAction.hashCode();
	}

	public java.lang.String toString() {
		return _kaleoAction.toString();
	}

	public java.lang.String toXmlString() {
		return _kaleoAction.toXmlString();
	}

	public KaleoAction getWrappedKaleoAction() {
		return _kaleoAction;
	}

	private KaleoAction _kaleoAction;
}