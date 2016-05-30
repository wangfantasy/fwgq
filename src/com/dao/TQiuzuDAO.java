package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TChuzu;
import com.model.TQiugou;
import com.model.TQiuzu;
import com.model.TQiuzu;

/**
 * Data access object (DAO) for domain model class TQiugou.
 * 
 * @see com.model.TQiugou
 * @author MyEclipse Persistence Tools
 */

public class TQiuzuDAO extends BaseDAO<TQiuzu>
{
	protected Class<TQiuzu> getModelClass(){
		return TQiuzu.class;
	}
	public static TQiuzuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TQiuzuDAO) ctx.getBean("TQiuzuDAO");
	}	
}