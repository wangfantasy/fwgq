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
			q.setFirstResult(first); // �ӵ�0����ʼ
			q.setMaxResults(max);
			return q.list();
			// return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			s.close();
		}
	}

	// ����merge() attachDirty() attachClean()���ַ���������һ���򵥵Ľ���
	/**
	 * �������detached״̬�Ķ�������Ը��Ƶ��־û������У������ظó־û�����
	 * �����session��û�й����ĳ־û����󣬼���һ��������������δ���棬����һ����������Ϊ�־ö��󷵻أ����������Ȼ����detached״̬��
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
	 * ������Ķ���־û������档
	 * �������δ���棨Transient״̬��������save�������档��������ѱ��棨Detached״̬��������update������������Session���¹�����
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
	 *            ��һ���������������� �ڶ�������������ֵ ��һ���������޶���ʽ��equals,like��
	 */
	public List<Model> findWithCondition(Map<String, String[]> condition,int first, int max) {
		return this.findWithCondition(condition, first, max, null, true);
	}
	/**
	 * @param condition
	 * ��һ���������������� �ڶ�������������ֵ ��һ���������޶���ʽ��equals,like��
	 * @param orderBy �����ֶ�
	 * @param isAsc �Ƿ��������У�false��Ϊ����
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
