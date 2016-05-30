package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TChushou;
import com.model.TChuzu;

/**
 * Data access object (DAO) for domain model class TChuzu.
 * 
 * @see com.model.TChuzu
 * @author MyEclipse Persistence Tools
 */

public class TChuzuDAO extends BaseDAO<TChuzu> {
	protected Class<TChuzu> getModelClass(){
		return TChuzu.class;
	}

	public static TChuzuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TChuzuDAO) ctx.getBean("TChuzuDAO");
	}
}