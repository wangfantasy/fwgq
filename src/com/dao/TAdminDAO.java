package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TAdmin;
import com.model.TChushou;

/**
 * Data access object (DAO) for domain model class TAdmin.
 * 
 * @see com.model.TAdmin
 * @author MyEclipse Persistence Tools
 */

public class TAdminDAO extends BaseDAO<TAdmin>{
	
	// property constants
	public static final String ADMIN_NAME = "adminName";

	public static final String ADMIN_PW = "adminPw";
	
	protected Class<TAdmin> getModelClass(){
		return TAdmin.class;
	}

	public List findByUserName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List findByUserPw(Object adminPw) {
		return findByProperty(ADMIN_PW, adminPw);
	}

	public List findAll() {
		try {
			String queryString = "from TAdmin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static TAdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TAdminDAO) ctx.getBean("TAdminDAO");
	}
}