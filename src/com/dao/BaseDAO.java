package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.util.StringUtils;

public abstract class BaseDAO<Model> extends HibernateDaoSupport {
	protected abstract Class<Model> getModelClass();

	// private final Log log = LogFactory.getLog(T);
	public void save(Serializable transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void delete(Serializable persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public Model findById(Integer id) {
		try {
			Model instance = (Model) getHibernateTemplate().get(
					getModelClass().getName(), id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<Model> findByExample(Object instance) {
		try {
			List<Model> results = getHibernateTemplate()
					.findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<Model> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from " + getModelClass().getSimpleName()
					+ " as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll(String hql, int first, int max) {
		Session s = getHibernateTemplate().getSessionFactory().openSession();
		try {
			Query q = s.createQuery(hql);
			q.setFirstResult(first); // 从第0条开始
			q.setMaxResults(max);
			return q.list();
			// return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			s.close();
		}
	}

	// 关于merge() attachDirty() attachClean()三种方法下面做一个简单的介绍
	/**
	 * 将传入的detached状态的对象的属性复制到持久化对象中，并返回该持久化对象。
	 * 如果该session中没有关联的持久化对象，加载一个，如果传入对象未保存，保存一个副本并作为持久对象返回，传入对象依然保持detached状态。
	 */

	public Object merge(Object detachedInstance) {
		try {
			Object result = getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 将传入的对象持久化并保存。
	 * 如果对象未保存（Transient状态），调用save方法保存。如果对象已保存（Detached状态），调用update方法将对象与Session重新关联。
	 */
	public void attachDirty(Object instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(Object instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * @param condition
	 *            第一个参数是属性名称 第二个参数是属性值 第一个参数是限定方式（equals,like）
	 */
	public List<Model> findWithCondition(Map<String, String[]> condition,int first, int max) {
		return this.findWithCondition(condition, first, max, null, true);
	}
	/**
	 * @param condition
	 * 第一个参数是属性名称 第二个参数是属性值 第一个参数是限定方式（equals,like）
	 * @param orderBy 排序字段
	 * @param isAsc 是否升序排列（false则为降序）
	 * @see com.dao.BaseDAO#findWithCondition(Map, int, int)
	 */
	public List<Model> findWithCondition(Map<String, String[]> condition,int first, int max, String orderBy, boolean isAsc) {
		Session s = getHibernateTemplate().getSessionFactory().openSession();
		Criteria c = s.createCriteria(getModelClass());
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 1;
		}
		c.setFirstResult(first);
		c.setMaxResults(max);
		Set<String> properties = condition.keySet();
		for (String propertyName : properties) {
			System.out.println(propertyName);
			String value = condition.get(propertyName)[0];
			String limit = condition.get(propertyName)[1];
			if ("equals".equals(limit)) {
				c.add(Restrictions.eq(propertyName, value));
			} else if ("like".equals(limit)) {
				c.add(Restrictions.like(propertyName, "%" + value + "%"));
			}
		}
		if (!StringUtils.isNull(orderBy)) {
			if (isAsc) {
				System.out.println("asc by "+orderBy);
				c.addOrder(Order.asc(orderBy));
			} else {
				c.addOrder(Order.desc(orderBy));
			}
		}
		List l = c.list();
		s.close();
		return l;
	}
}
