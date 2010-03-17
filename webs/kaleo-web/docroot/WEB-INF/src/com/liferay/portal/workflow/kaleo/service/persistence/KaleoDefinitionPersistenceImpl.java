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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.workflow.kaleo.NoSuchDefinitionException;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoDefinitionImpl;
import com.liferay.portal.workflow.kaleo.model.impl.KaleoDefinitionModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="KaleoDefinitionPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoDefinitionPersistence
 * @see       KaleoDefinitionUtil
 * @generated
 */
public class KaleoDefinitionPersistenceImpl extends BasePersistenceImpl<KaleoDefinition>
	implements KaleoDefinitionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = KaleoDefinitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPANYID = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_C_N = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByC_N",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_C_N = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByC_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_C_N = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByC_N",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_N_V = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_N_V",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_C_N_V = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByC_N_V",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	public void cacheResult(KaleoDefinition kaleoDefinition) {
		EntityCacheUtil.putResult(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionImpl.class, kaleoDefinition.getPrimaryKey(),
			kaleoDefinition);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_N_V,
			new Object[] {
				new Long(kaleoDefinition.getCompanyId()),
				
			kaleoDefinition.getName(), new Integer(kaleoDefinition.getVersion())
			}, kaleoDefinition);
	}

	public void cacheResult(List<KaleoDefinition> kaleoDefinitions) {
		for (KaleoDefinition kaleoDefinition : kaleoDefinitions) {
			if (EntityCacheUtil.getResult(
						KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
						KaleoDefinitionImpl.class,
						kaleoDefinition.getPrimaryKey(), this) == null) {
				cacheResult(kaleoDefinition);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(KaleoDefinitionImpl.class.getName());
		EntityCacheUtil.clearCache(KaleoDefinitionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public KaleoDefinition create(long kaleoDefinitionId) {
		KaleoDefinition kaleoDefinition = new KaleoDefinitionImpl();

		kaleoDefinition.setNew(true);
		kaleoDefinition.setPrimaryKey(kaleoDefinitionId);

		return kaleoDefinition;
	}

	public KaleoDefinition remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	public KaleoDefinition remove(long kaleoDefinitionId)
		throws NoSuchDefinitionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KaleoDefinition kaleoDefinition = (KaleoDefinition)session.get(KaleoDefinitionImpl.class,
					new Long(kaleoDefinitionId));

			if (kaleoDefinition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						kaleoDefinitionId);
				}

				throw new NoSuchDefinitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					kaleoDefinitionId);
			}

			return remove(kaleoDefinition);
		}
		catch (NoSuchDefinitionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public KaleoDefinition remove(KaleoDefinition kaleoDefinition)
		throws SystemException {
		for (ModelListener<KaleoDefinition> listener : listeners) {
			listener.onBeforeRemove(kaleoDefinition);
		}

		kaleoDefinition = removeImpl(kaleoDefinition);

		for (ModelListener<KaleoDefinition> listener : listeners) {
			listener.onAfterRemove(kaleoDefinition);
		}

		return kaleoDefinition;
	}

	protected KaleoDefinition removeImpl(KaleoDefinition kaleoDefinition)
		throws SystemException {
		kaleoDefinition = toUnwrappedModel(kaleoDefinition);

		Session session = null;

		try {
			session = openSession();

			if (kaleoDefinition.isCachedModel() ||
					BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(KaleoDefinitionImpl.class,
						kaleoDefinition.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(kaleoDefinition);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		KaleoDefinitionModelImpl kaleoDefinitionModelImpl = (KaleoDefinitionModelImpl)kaleoDefinition;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_N_V,
			new Object[] {
				new Long(kaleoDefinitionModelImpl.getOriginalCompanyId()),
				
			kaleoDefinitionModelImpl.getOriginalName(),
				new Integer(kaleoDefinitionModelImpl.getOriginalVersion())
			});

		EntityCacheUtil.removeResult(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionImpl.class, kaleoDefinition.getPrimaryKey());

		return kaleoDefinition;
	}

	public KaleoDefinition updateImpl(
		com.liferay.portal.workflow.kaleo.model.KaleoDefinition kaleoDefinition,
		boolean merge) throws SystemException {
		kaleoDefinition = toUnwrappedModel(kaleoDefinition);

		boolean isNew = kaleoDefinition.isNew();

		KaleoDefinitionModelImpl kaleoDefinitionModelImpl = (KaleoDefinitionModelImpl)kaleoDefinition;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, kaleoDefinition, merge);

			kaleoDefinition.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
			KaleoDefinitionImpl.class, kaleoDefinition.getPrimaryKey(),
			kaleoDefinition);

		if (!isNew &&
				((kaleoDefinition.getCompanyId() != kaleoDefinitionModelImpl.getOriginalCompanyId()) ||
				!Validator.equals(kaleoDefinition.getName(),
					kaleoDefinitionModelImpl.getOriginalName()) ||
				(kaleoDefinition.getVersion() != kaleoDefinitionModelImpl.getOriginalVersion()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_N_V,
				new Object[] {
					new Long(kaleoDefinitionModelImpl.getOriginalCompanyId()),
					
				kaleoDefinitionModelImpl.getOriginalName(),
					new Integer(kaleoDefinitionModelImpl.getOriginalVersion())
				});
		}

		if (isNew ||
				((kaleoDefinition.getCompanyId() != kaleoDefinitionModelImpl.getOriginalCompanyId()) ||
				!Validator.equals(kaleoDefinition.getName(),
					kaleoDefinitionModelImpl.getOriginalName()) ||
				(kaleoDefinition.getVersion() != kaleoDefinitionModelImpl.getOriginalVersion()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_N_V,
				new Object[] {
					new Long(kaleoDefinition.getCompanyId()),
					
				kaleoDefinition.getName(),
					new Integer(kaleoDefinition.getVersion())
				}, kaleoDefinition);
		}

		return kaleoDefinition;
	}

	protected KaleoDefinition toUnwrappedModel(KaleoDefinition kaleoDefinition) {
		if (kaleoDefinition instanceof KaleoDefinitionImpl) {
			return kaleoDefinition;
		}

		KaleoDefinitionImpl kaleoDefinitionImpl = new KaleoDefinitionImpl();

		kaleoDefinitionImpl.setNew(kaleoDefinition.isNew());
		kaleoDefinitionImpl.setPrimaryKey(kaleoDefinition.getPrimaryKey());

		kaleoDefinitionImpl.setKaleoDefinitionId(kaleoDefinition.getKaleoDefinitionId());
		kaleoDefinitionImpl.setCompanyId(kaleoDefinition.getCompanyId());
		kaleoDefinitionImpl.setUserId(kaleoDefinition.getUserId());
		kaleoDefinitionImpl.setUserName(kaleoDefinition.getUserName());
		kaleoDefinitionImpl.setCreateDate(kaleoDefinition.getCreateDate());
		kaleoDefinitionImpl.setModifiedDate(kaleoDefinition.getModifiedDate());
		kaleoDefinitionImpl.setName(kaleoDefinition.getName());
		kaleoDefinitionImpl.setDescription(kaleoDefinition.getDescription());
		kaleoDefinitionImpl.setVersion(kaleoDefinition.getVersion());
		kaleoDefinitionImpl.setActive(kaleoDefinition.isActive());
		kaleoDefinitionImpl.setStartKaleoNodeId(kaleoDefinition.getStartKaleoNodeId());

		return kaleoDefinitionImpl;
	}

	public KaleoDefinition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	public KaleoDefinition findByPrimaryKey(long kaleoDefinitionId)
		throws NoSuchDefinitionException, SystemException {
		KaleoDefinition kaleoDefinition = fetchByPrimaryKey(kaleoDefinitionId);

		if (kaleoDefinition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + kaleoDefinitionId);
			}

			throw new NoSuchDefinitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				kaleoDefinitionId);
		}

		return kaleoDefinition;
	}

	public KaleoDefinition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	public KaleoDefinition fetchByPrimaryKey(long kaleoDefinitionId)
		throws SystemException {
		KaleoDefinition kaleoDefinition = (KaleoDefinition)EntityCacheUtil.getResult(KaleoDefinitionModelImpl.ENTITY_CACHE_ENABLED,
				KaleoDefinitionImpl.class, kaleoDefinitionId, this);

		if (kaleoDefinition == null) {
			Session session = null;

			try {
				session = openSession();

				kaleoDefinition = (KaleoDefinition)session.get(KaleoDefinitionImpl.class,
						new Long(kaleoDefinitionId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (kaleoDefinition != null) {
					cacheResult(kaleoDefinition);
				}

				closeSession(session);
			}
		}

		return kaleoDefinition;
	}

	public List<KaleoDefinition> findByCompanyId(long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(companyId) };

		List<KaleoDefinition> list = (List<KaleoDefinition>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

				query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoDefinition>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<KaleoDefinition> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	public List<KaleoDefinition> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(companyId),
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoDefinition> list = (List<KaleoDefinition>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<KaleoDefinition>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoDefinition>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public KaleoDefinition findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		List<KaleoDefinition> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDefinitionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoDefinition findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		int count = countByCompanyId(companyId);

		List<KaleoDefinition> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDefinitionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoDefinition[] findByCompanyId_PrevAndNext(
		long kaleoDefinitionId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		KaleoDefinition kaleoDefinition = findByPrimaryKey(kaleoDefinitionId);

		int count = countByCompanyId(companyId);

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count,
					orderByComparator, kaleoDefinition);

			KaleoDefinition[] array = new KaleoDefinitionImpl[3];

			array[0] = (KaleoDefinition)objArray[0];
			array[1] = (KaleoDefinition)objArray[1];
			array[2] = (KaleoDefinition)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<KaleoDefinition> findByC_N(long companyId, String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(companyId), name };

		List<KaleoDefinition> list = (List<KaleoDefinition>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_C_N,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

				if (name == null) {
					query.append(_FINDER_COLUMN_C_N_NAME_1);
				}
				else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_NAME_2);
					}
				}

				query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoDefinition>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_C_N, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<KaleoDefinition> findByC_N(long companyId, String name,
		int start, int end) throws SystemException {
		return findByC_N(companyId, name, start, end, null);
	}

	public List<KaleoDefinition> findByC_N(long companyId, String name,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(companyId),
				
				name,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoDefinition> list = (List<KaleoDefinition>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_C_N,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

				if (name == null) {
					query.append(_FINDER_COLUMN_C_N_NAME_1);
				}
				else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_NAME_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<KaleoDefinition>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoDefinition>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_C_N,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public KaleoDefinition findByC_N_First(long companyId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		List<KaleoDefinition> list = findByC_N(companyId, name, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDefinitionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoDefinition findByC_N_Last(long companyId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		int count = countByC_N(companyId, name);

		List<KaleoDefinition> list = findByC_N(companyId, name, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDefinitionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public KaleoDefinition[] findByC_N_PrevAndNext(long kaleoDefinitionId,
		long companyId, String name, OrderByComparator orderByComparator)
		throws NoSuchDefinitionException, SystemException {
		KaleoDefinition kaleoDefinition = findByPrimaryKey(kaleoDefinitionId);

		int count = countByC_N(companyId, name);

		Session session = null;

		try {
			session = openSession();

			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			if (name == null) {
				query.append(_FINDER_COLUMN_C_N_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_N_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_N_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (name != null) {
				qPos.add(name);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count,
					orderByComparator, kaleoDefinition);

			KaleoDefinition[] array = new KaleoDefinitionImpl[3];

			array[0] = (KaleoDefinition)objArray[0];
			array[1] = (KaleoDefinition)objArray[1];
			array[2] = (KaleoDefinition)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public KaleoDefinition findByC_N_V(long companyId, String name, int version)
		throws NoSuchDefinitionException, SystemException {
		KaleoDefinition kaleoDefinition = fetchByC_N_V(companyId, name, version);

		if (kaleoDefinition == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", name=");
			msg.append(name);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDefinitionException(msg.toString());
		}

		return kaleoDefinition;
	}

	public KaleoDefinition fetchByC_N_V(long companyId, String name, int version)
		throws SystemException {
		return fetchByC_N_V(companyId, name, version, true);
	}

	public KaleoDefinition fetchByC_N_V(long companyId, String name,
		int version, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(companyId),
				
				name, new Integer(version)
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_N_V,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(5);

				query.append(_SQL_SELECT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_C_N_V_COMPANYID_2);

				if (name == null) {
					query.append(_FINDER_COLUMN_C_N_V_NAME_1);
				}
				else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_V_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_V_NAME_2);
					}
				}

				query.append(_FINDER_COLUMN_C_N_V_VERSION_2);

				query.append(KaleoDefinitionModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				qPos.add(version);

				List<KaleoDefinition> list = q.list();

				result = list;

				KaleoDefinition kaleoDefinition = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_N_V,
						finderArgs, list);
				}
				else {
					kaleoDefinition = list.get(0);

					cacheResult(kaleoDefinition);

					if ((kaleoDefinition.getCompanyId() != companyId) ||
							(kaleoDefinition.getName() == null) ||
							!kaleoDefinition.getName().equals(name) ||
							(kaleoDefinition.getVersion() != version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_N_V,
							finderArgs, kaleoDefinition);
					}
				}

				return kaleoDefinition;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_N_V,
						finderArgs, new ArrayList<KaleoDefinition>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (KaleoDefinition)result;
			}
		}
	}

	public List<KaleoDefinition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<KaleoDefinition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<KaleoDefinition> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<KaleoDefinition> list = (List<KaleoDefinition>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_KALEODEFINITION);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}

				else {
					sql = _SQL_SELECT_KALEODEFINITION.concat(KaleoDefinitionModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<KaleoDefinition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<KaleoDefinition>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<KaleoDefinition>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByCompanyId(long companyId) throws SystemException {
		for (KaleoDefinition kaleoDefinition : findByCompanyId(companyId)) {
			remove(kaleoDefinition);
		}
	}

	public void removeByC_N(long companyId, String name)
		throws SystemException {
		for (KaleoDefinition kaleoDefinition : findByC_N(companyId, name)) {
			remove(kaleoDefinition);
		}
	}

	public void removeByC_N_V(long companyId, String name, int version)
		throws NoSuchDefinitionException, SystemException {
		KaleoDefinition kaleoDefinition = findByC_N_V(companyId, name, version);

		remove(kaleoDefinition);
	}

	public void removeAll() throws SystemException {
		for (KaleoDefinition kaleoDefinition : findAll()) {
			remove(kaleoDefinition);
		}
	}

	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(companyId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByC_N(long companyId, String name)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(companyId), name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_N,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

				if (name == null) {
					query.append(_FINDER_COLUMN_C_N_NAME_1);
				}
				else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_NAME_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_N, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByC_N_V(long companyId, String name, int version)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(companyId),
				
				name, new Integer(version)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_N_V,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_KALEODEFINITION_WHERE);

				query.append(_FINDER_COLUMN_C_N_V_COMPANYID_2);

				if (name == null) {
					query.append(_FINDER_COLUMN_C_N_V_NAME_1);
				}
				else {
					if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_V_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_V_NAME_2);
					}
				}

				query.append(_FINDER_COLUMN_C_N_V_VERSION_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (name != null) {
					qPos.add(name);
				}

				qPos.add(version);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_N_V,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KALEODEFINITION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public List<com.liferay.portal.workflow.kaleo.model.KaleoNode> getKaleoNodes(
		long pk) throws SystemException {
		return getKaleoNodes(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<com.liferay.portal.workflow.kaleo.model.KaleoNode> getKaleoNodes(
		long pk, int start, int end) throws SystemException {
		return getKaleoNodes(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_KALEONODES = new FinderPath(com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getKaleoNodes",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	public List<com.liferay.portal.workflow.kaleo.model.KaleoNode> getKaleoNodes(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(pk), String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.liferay.portal.workflow.kaleo.model.KaleoNode> list = (List<com.liferay.portal.workflow.kaleo.model.KaleoNode>)FinderCacheUtil.getResult(FINDER_PATH_GET_KALEONODES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETKALEONODES.concat(ORDER_BY_CLAUSE)
											.concat(orderByComparator.getOrderBy());
				}

				else {
					sql = _SQL_GETKALEONODES.concat(com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Kaleo_KaleoNode",
					com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.liferay.portal.workflow.kaleo.model.KaleoNode>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<com.liferay.portal.workflow.kaleo.model.KaleoNode>();
				}

				kaleoNodePersistence.cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_GET_KALEONODES,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_KALEONODES_SIZE = new FinderPath(com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getKaleoNodesSize", new String[] { Long.class.getName() });

	public int getKaleoNodesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(pk) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_KALEONODES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETKALEONODESSIZE);

				q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_KALEONODES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_KALEONODE = new FinderPath(com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.model.impl.KaleoNodeModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsKaleoNode",
			new String[] { Long.class.getName(), Long.class.getName() });

	public boolean containsKaleoNode(long pk, long kaleoNodePK)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(pk), new Long(kaleoNodePK) };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_KALEONODE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsKaleoNode.contains(pk,
							kaleoNodePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_KALEONODE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	public boolean containsKaleoNodes(long pk) throws SystemException {
		if (getKaleoNodesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.workflow.kaleo.model.KaleoDefinition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KaleoDefinition>> listenersList = new ArrayList<ModelListener<KaleoDefinition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KaleoDefinition>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsKaleoNode = new ContainsKaleoNode(this);
	}

	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoActionPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoActionPersistence kaleoActionPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoDefinitionPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoDefinitionPersistence kaleoDefinitionPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstancePersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstancePersistence kaleoInstancePersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstanceTokenPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoInstanceTokenPersistence kaleoInstanceTokenPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoLogPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoLogPersistence kaleoLogPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoNodePersistence kaleoNodePersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskPersistence kaleoTaskPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskAssignmentPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskAssignmentPersistence kaleoTaskAssignmentPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceAssignmentPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceAssignmentPersistence kaleoTaskInstanceAssignmentPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoTaskInstanceTokenPersistence kaleoTaskInstanceTokenPersistence;
	@BeanReference(name = "com.liferay.portal.workflow.kaleo.service.persistence.KaleoTransitionPersistence")
	protected com.liferay.portal.workflow.kaleo.service.persistence.KaleoTransitionPersistence kaleoTransitionPersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence")
	protected com.liferay.portal.service.persistence.ResourcePersistence resourcePersistence;
	@BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence")
	protected com.liferay.portal.service.persistence.UserPersistence userPersistence;
	protected ContainsKaleoNode containsKaleoNode;

	protected class ContainsKaleoNode {
		protected ContainsKaleoNode(
			KaleoDefinitionPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSKALEONODE,
					new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
		}

		protected boolean contains(long kaleoDefinitionId, long kaleoNodeId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(kaleoDefinitionId), new Long(kaleoNodeId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_KALEODEFINITION = "SELECT kaleoDefinition FROM KaleoDefinition kaleoDefinition";
	private static final String _SQL_SELECT_KALEODEFINITION_WHERE = "SELECT kaleoDefinition FROM KaleoDefinition kaleoDefinition WHERE ";
	private static final String _SQL_COUNT_KALEODEFINITION = "SELECT COUNT(kaleoDefinition) FROM KaleoDefinition kaleoDefinition";
	private static final String _SQL_COUNT_KALEODEFINITION_WHERE = "SELECT COUNT(kaleoDefinition) FROM KaleoDefinition kaleoDefinition WHERE ";
	private static final String _SQL_GETKALEONODES = "SELECT {Kaleo_KaleoNode.*} FROM Kaleo_KaleoNode INNER JOIN Kaleo_KaleoDefinition ON (Kaleo_KaleoDefinition.kaleoDefinitionId = Kaleo_KaleoNode.kaleoDefinitionId) WHERE (Kaleo_KaleoDefinition.kaleoDefinitionId = ?)";
	private static final String _SQL_GETKALEONODESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Kaleo_KaleoNode WHERE kaleoDefinitionId = ?";
	private static final String _SQL_CONTAINSKALEONODE = "SELECT COUNT(*) AS COUNT_VALUE FROM Kaleo_KaleoNode WHERE kaleoDefinitionId = ? AND kaleoNodeId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "kaleoDefinition.companyId = ?";
	private static final String _FINDER_COLUMN_C_N_COMPANYID_2 = "kaleoDefinition.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_NAME_1 = "kaleoDefinition.name IS NULL";
	private static final String _FINDER_COLUMN_C_N_NAME_2 = "kaleoDefinition.name = ?";
	private static final String _FINDER_COLUMN_C_N_NAME_3 = "(kaleoDefinition.name IS NULL OR kaleoDefinition.name = ?)";
	private static final String _FINDER_COLUMN_C_N_V_COMPANYID_2 = "kaleoDefinition.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_V_NAME_1 = "kaleoDefinition.name IS NULL AND ";
	private static final String _FINDER_COLUMN_C_N_V_NAME_2 = "kaleoDefinition.name = ? AND ";
	private static final String _FINDER_COLUMN_C_N_V_NAME_3 = "(kaleoDefinition.name IS NULL OR kaleoDefinition.name = ?) AND ";
	private static final String _FINDER_COLUMN_C_N_V_VERSION_2 = "kaleoDefinition.version = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kaleoDefinition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KaleoDefinition exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KaleoDefinition exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(KaleoDefinitionPersistenceImpl.class);
}