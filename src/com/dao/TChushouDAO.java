package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TAdmin;
import com.model.TChushou;

/**
 * Data access object (DAO) for domain model class TChushou.
 * 
 * @see com.model.TChushou
 * @author MyEclipse Persistence Tools
 */

public class TChushouDAO extends BaseDAO<TChushou> {

	protected Class<TChushou> getModelClass(){
		return TChushou.class;
	}

	public static TChushouDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TChushouDAO) ctx.getBean("TChushouDAO");
	}
}