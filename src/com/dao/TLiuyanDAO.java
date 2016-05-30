package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TAdmin;
import com.model.TGonggao;
import com.model.TLiuyan;
import com.model.TUser;

/**
 * Data access object (DAO) for domain model class TLiuyan.
 * 
 * @see com.model.TLiuyan
 * @author MyEclipse Persistence Tools
 */

public class TLiuyanDAO extends BaseDAO<TLiuyan> {
	private static final Log log = LogFactory.getLog(TLiuyanDAO.class);
	protected Class<TLiuyan> getModelClass(){
		return TLiuyan.class;
	}
	// property constants
	public static final String LIUYAN_TITLE = "liuyanTitle";

	public static final String LIUYAN_CONTENT = "liuyanContent";

	public static final String LIUYAN_FABUZHE = "liuyanFabuzhe";

	public static final String LIUYAN_ONE1 = "liuyanOne1";

	public static final String LIUYAN_ONE2 = "liuyanOne2";

	public static final String LIUYAN_ONE3 = "liuyanOne3";

	public static final String LIUYAN_ONE4 = "liuyanOne4";

	public static final String LIUYAN_ONE7 = "liuyanOne7";

	public static final String LIUYAN_ONE8 = "liuyanOne8";

	

	public void save(TUser user, TLiuyan transientInstance) {
		log.debug("saving TLiuyan instance");
		HibernateTemplate ht = getHibernateTemplate();
		SessionFactory sf = ht.getSessionFactory();
		Session s = sf.openSession();
		try {
			int uid = user.getUserId();
			Transaction t = s.beginTransaction();
			TUser tuser = (TUser) s.get(TUser.class, uid);
			tuser.getLiuyans().add(transientInstance);
			s.save(tuser);
			t.commit();
			log.debug("save successful");
			System.out.println(this.getClass().getName() + ".save ok");
		} catch (RuntimeException re) {
			System.out.println(this.getClass().getName() + ".save error");
			log.error("save failed", re);
			throw re;
		} finally {
			s.close();
		}
		System.out.println(this.getClass().getName() + ".save");
	}

	public void save(TLiuyan tLiuYan) {
		log.debug("saving TLiuyan instance");
		HibernateTemplate ht = getHibernateTemplate();
		SessionFactory sf = ht.getSessionFactory();
		Session s = sf.openSession();
		try {
			Transaction t = s.beginTransaction();
			TLiuyan tl = (TLiuyan) s.get("com.model.TLiuyan", tLiuYan
					.getLiuyanId());
			tl.setHuifuContent(tLiuYan.getHuifuContent());
			tl.setHuifuDate(tLiuYan.getHuifuDate());
			s.save(tl);

			t.commit();
			log.debug("save successful");
			System.out.println(this.getClass().getName() + ".save ok");
		} catch (RuntimeException re) {
			System.out.println(this.getClass().getName() + ".save error");
			log.error("save failed", re);
			throw re;
		} finally {
			s.close();
		}
		System.out.println(this.getClass().getName() + ".save");
	}

	public List findByLiuyanTitle(Object liuyanTitle) {
		return findByProperty(LIUYAN_TITLE, liuyanTitle);
	}

	public List findByLiuyanContent(Object liuyanContent) {
		return findByProperty(LIUYAN_CONTENT, liuyanContent);
	}

	public List findByLiuyanFabuzhe(Object liuyanFabuzhe) {
		return findByProperty(LIUYAN_FABUZHE, liuyanFabuzhe);
	}

	public List findByLiuyanOne1(Object liuyanOne1) {
		return findByProperty(LIUYAN_ONE1, liuyanOne1);
	}

	public List findByLiuyanOne2(Object liuyanOne2) {
		return findByProperty(LIUYAN_ONE2, liuyanOne2);
	}

	public List findByLiuyanOne3(Object liuyanOne3) {
		return findByProperty(LIUYAN_ONE3, liuyanOne3);
	}

	public List findByLiuyanOne4(Object liuyanOne4) {
		return findByProperty(LIUYAN_ONE4, liuyanOne4);
	}

	public List findByLiuyanOne7(Object liuyanOne7) {
		return findByProperty(LIUYAN_ONE7, liuyanOne7);
	}

	public List findByLiuyanOne8(Object liuyanOne8) {
		return findByProperty(LIUYAN_ONE8, liuyanOne8);
	}

	public List findAll() {
		log.debug("finding all TLiuyan instances");
		try {
			String queryString = "from TLiuyan order by liuyanId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public static TLiuyanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TLiuyanDAO) ctx.getBean("TLiuyanDAO");
	}
}