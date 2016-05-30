package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TAdmin;
import com.model.TChuzu;
import com.model.TGonggao;

/**
 * Data access object (DAO) for domain model class TGonggao.
 * 
 * @see com.model.TGonggao
 * @author MyEclipse Persistence Tools
 */

public class TGonggaoDAO extends BaseDAO<TGonggao>
{
	protected Class<TGonggao> getModelClass(){
		return TGonggao.class;
	}
	// property constants
	public static final String GONGGAO_TITLE = "gonggaoTitle";

	public static final String GONGGAO_CONTENT = "gonggaoContent";

	public static final String GONGGAO_FABUZHE = "gonggaoFabuzhe";

	public static final String GONGGAO_ONE1 = "gonggaoOne1";

	public static final String GONGGAO_ONE2 = "gonggaoOne2";

	public static final String GONGGAO_ONE3 = "gonggaoOne3";

	public static final String GONGGAO_ONE4 = "gonggaoOne4";

	public static final String GONGGAO_ONE7 = "gonggaoOne7";

	public static final String GONGGAO_ONE8 = "gonggaoOne8";


	public List findByGonggaoTitle(Object gonggaoTitle)
	{
		return findByProperty(GONGGAO_TITLE, gonggaoTitle);
	}

	public List findByGonggaoContent(Object gonggaoContent)
	{
		return findByProperty(GONGGAO_CONTENT, gonggaoContent);
	}

	public List findByGonggaoFabuzhe(Object gonggaoFabuzhe)
	{
		return findByProperty(GONGGAO_FABUZHE, gonggaoFabuzhe);
	}

	public List findByGonggaoOne1(Object gonggaoOne1)
	{
		return findByProperty(GONGGAO_ONE1, gonggaoOne1);
	}

	public List findByGonggaoOne2(Object gonggaoOne2)
	{
		return findByProperty(GONGGAO_ONE2, gonggaoOne2);
	}

	public List findByGonggaoOne3(Object gonggaoOne3)
	{
		return findByProperty(GONGGAO_ONE3, gonggaoOne3);
	}

	public List findByGonggaoOne4(Object gonggaoOne4)
	{
		return findByProperty(GONGGAO_ONE4, gonggaoOne4);
	}

	public List findByGonggaoOne7(Object gonggaoOne7)
	{
		return findByProperty(GONGGAO_ONE7, gonggaoOne7);
	}

	public List findByGonggaoOne8(Object gonggaoOne8)
	{
		return findByProperty(GONGGAO_ONE8, gonggaoOne8);
	}

	public List findAll()
	{
		try
		{
			String queryString = "from TGonggao order by gonggaoId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			throw re;
		}
	}

	public static TGonggaoDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGonggaoDAO) ctx.getBean("TGonggaoDAO");
	}
}