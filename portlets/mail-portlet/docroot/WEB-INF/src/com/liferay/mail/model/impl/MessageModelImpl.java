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

package com.liferay.mail.model.impl;

import com.liferay.mail.model.Message;
import com.liferay.mail.model.MessageSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="MessageModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the Mail_Message table in the
 * database.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MessageImpl
 * @see       com.liferay.mail.model.Message
 * @see       com.liferay.mail.model.MessageModel
 * @generated
 */
public class MessageModelImpl extends BaseModelImpl<Message> {
	public static final String TABLE_NAME = "Mail_Message";
	public static final Object[][] TABLE_COLUMNS = {
			{ "messageId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "userName", new Integer(Types.VARCHAR) },
			{ "createDate", new Integer(Types.TIMESTAMP) },
			{ "modifiedDate", new Integer(Types.TIMESTAMP) },
			{ "accountId", new Integer(Types.BIGINT) },
			{ "folderId", new Integer(Types.BIGINT) },
			{ "sender", new Integer(Types.VARCHAR) },
			{ "recipientsTo", new Integer(Types.VARCHAR) },
			{ "recipientsCc", new Integer(Types.VARCHAR) },
			{ "recipientsBcc", new Integer(Types.VARCHAR) },
			{ "sentDate", new Integer(Types.TIMESTAMP) },
			{ "subject", new Integer(Types.VARCHAR) },
			{ "preview", new Integer(Types.VARCHAR) },
			{ "body", new Integer(Types.VARCHAR) },
			{ "flags", new Integer(Types.VARCHAR) },
			{ "size_", new Integer(Types.BIGINT) },
			{ "remoteMessageId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table Mail_Message (messageId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,accountId LONG,folderId LONG,sender VARCHAR(75) null,recipientsTo VARCHAR(75) null,recipientsCc VARCHAR(75) null,recipientsBcc VARCHAR(75) null,sentDate DATE null,subject VARCHAR(75) null,preview VARCHAR(75) null,body VARCHAR(75) null,flags VARCHAR(75) null,size_ LONG,remoteMessageId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Mail_Message";
	public static final String ORDER_BY_JPQL = " ORDER BY message.sentDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Mail_Message.sentDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.mail.model.Message"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.mail.model.Message"),
			true);

	public static Message toModel(MessageSoap soapModel) {
		Message model = new MessageImpl();

		model.setMessageId(soapModel.getMessageId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAccountId(soapModel.getAccountId());
		model.setFolderId(soapModel.getFolderId());
		model.setSender(soapModel.getSender());
		model.setRecipientsTo(soapModel.getRecipientsTo());
		model.setRecipientsCc(soapModel.getRecipientsCc());
		model.setRecipientsBcc(soapModel.getRecipientsBcc());
		model.setSentDate(soapModel.getSentDate());
		model.setSubject(soapModel.getSubject());
		model.setPreview(soapModel.getPreview());
		model.setBody(soapModel.getBody());
		model.setFlags(soapModel.getFlags());
		model.setSize(soapModel.getSize());
		model.setRemoteMessageId(soapModel.getRemoteMessageId());

		return model;
	}

	public static List<Message> toModels(MessageSoap[] soapModels) {
		List<Message> models = new ArrayList<Message>(soapModels.length);

		for (MessageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.mail.model.Message"));

	public MessageModelImpl() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_messageId);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;

		if (!_setOriginalFolderId) {
			_setOriginalFolderId = true;

			_originalFolderId = folderId;
		}
	}

	public long getOriginalFolderId() {
		return _originalFolderId;
	}

	public String getSender() {
		if (_sender == null) {
			return StringPool.BLANK;
		}
		else {
			return _sender;
		}
	}

	public void setSender(String sender) {
		_sender = sender;
	}

	public String getRecipientsTo() {
		if (_recipientsTo == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipientsTo;
		}
	}

	public void setRecipientsTo(String recipientsTo) {
		_recipientsTo = recipientsTo;
	}

	public String getRecipientsCc() {
		if (_recipientsCc == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipientsCc;
		}
	}

	public void setRecipientsCc(String recipientsCc) {
		_recipientsCc = recipientsCc;
	}

	public String getRecipientsBcc() {
		if (_recipientsBcc == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipientsBcc;
		}
	}

	public void setRecipientsBcc(String recipientsBcc) {
		_recipientsBcc = recipientsBcc;
	}

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public String getSubject() {
		if (_subject == null) {
			return StringPool.BLANK;
		}
		else {
			return _subject;
		}
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getPreview() {
		if (_preview == null) {
			return StringPool.BLANK;
		}
		else {
			return _preview;
		}
	}

	public void setPreview(String preview) {
		_preview = preview;
	}

	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	public void setBody(String body) {
		_body = body;
	}

	public String getFlags() {
		if (_flags == null) {
			return StringPool.BLANK;
		}
		else {
			return _flags;
		}
	}

	public void setFlags(String flags) {
		_flags = flags;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public long getRemoteMessageId() {
		return _remoteMessageId;
	}

	public void setRemoteMessageId(long remoteMessageId) {
		_remoteMessageId = remoteMessageId;

		if (!_setOriginalRemoteMessageId) {
			_setOriginalRemoteMessageId = true;

			_originalRemoteMessageId = remoteMessageId;
		}
	}

	public long getOriginalRemoteMessageId() {
		return _originalRemoteMessageId;
	}

	public Message toEscapedModel() {
		if (isEscapedModel()) {
			return (Message)this;
		}
		else {
			return (Message)Proxy.newProxyInstance(Message.class.getClassLoader(),
				new Class[] { Message.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Message.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		MessageImpl clone = new MessageImpl();

		clone.setMessageId(getMessageId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAccountId(getAccountId());
		clone.setFolderId(getFolderId());
		clone.setSender(getSender());
		clone.setRecipientsTo(getRecipientsTo());
		clone.setRecipientsCc(getRecipientsCc());
		clone.setRecipientsBcc(getRecipientsBcc());
		clone.setSentDate(getSentDate());
		clone.setSubject(getSubject());
		clone.setPreview(getPreview());
		clone.setBody(getBody());
		clone.setFlags(getFlags());
		clone.setSize(getSize());
		clone.setRemoteMessageId(getRemoteMessageId());

		return clone;
	}

	public int compareTo(Message message) {
		int value = 0;

		value = DateUtil.compareTo(getSentDate(), message.getSentDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Message message = null;

		try {
			message = (Message)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = message.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", sender=");
		sb.append(getSender());
		sb.append(", recipientsTo=");
		sb.append(getRecipientsTo());
		sb.append(", recipientsCc=");
		sb.append(getRecipientsCc());
		sb.append(", recipientsBcc=");
		sb.append(getRecipientsBcc());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", preview=");
		sb.append(getPreview());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", flags=");
		sb.append(getFlags());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", remoteMessageId=");
		sb.append(getRemoteMessageId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.liferay.mail.model.Message");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sender</column-name><column-value><![CDATA[");
		sb.append(getSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipientsTo</column-name><column-value><![CDATA[");
		sb.append(getRecipientsTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipientsCc</column-name><column-value><![CDATA[");
		sb.append(getRecipientsCc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipientsBcc</column-name><column-value><![CDATA[");
		sb.append(getRecipientsBcc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preview</column-name><column-value><![CDATA[");
		sb.append(getPreview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flags</column-name><column-value><![CDATA[");
		sb.append(getFlags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteMessageId</column-name><column-value><![CDATA[");
		sb.append(getRemoteMessageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _messageId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _accountId;
	private long _folderId;
	private long _originalFolderId;
	private boolean _setOriginalFolderId;
	private String _sender;
	private String _recipientsTo;
	private String _recipientsCc;
	private String _recipientsBcc;
	private Date _sentDate;
	private String _subject;
	private String _preview;
	private String _body;
	private String _flags;
	private long _size;
	private long _remoteMessageId;
	private long _originalRemoteMessageId;
	private boolean _setOriginalRemoteMessageId;
	private transient ExpandoBridge _expandoBridge;
}