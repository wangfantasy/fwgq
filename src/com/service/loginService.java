package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TUserDAO;
import com.model.TAdmin;
import com.model.TUser;
import com.util.StringUtils;

public class loginService {
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public String login(String userName, String userPw, int userType) {
		System.out.println("userType" + userType);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "no";

		if (userType == 0)// 系统管理员登陆
		{
			String sql = "from TAdmin where adminName=? and adminPw=?";
			Object[] con = { userName, userPw };
			List adminList = adminDAO.getHibernateTemplate().find(sql, con);
			if (adminList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TAdmin admin = (TAdmin) adminList.get(0);
				session.setAttribute("userType", 0);
				session.setAttribute("admin", admin);
				result = "yes";
			}
		}

		if (userType == 1) {
			System.out.println("用户登录");
			String sql = "from TUser where userDel='no' and userName=? and userPw=?";
			Object[] con = { userName, userPw };
			List userList = userDAO.getHibernateTemplate().find(sql, con);
			if (userList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TUser user = (TUser) userList.get(0);
				session.setAttribute("userType", 1);
				session.setAttribute("user", user);
				result = "yes";
			}
		}

		if (userType == 1)// 员登陆
		{
			String sql = "from TUser where userName=? and userPw=?";
			Object[] con = { userName, userPw };
			List userList = userDAO.getHibernateTemplate().find(sql, con);
			if (userList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TUser user = (TUser) userList.get(0);
				session.setAttribute("userType", 1);
				session.setAttribute("user", user);
				result = "yes";
			}
		}

		if (userType == 2) {

		}
		return result;
	}

	public String logout() {
		System.out.println("DDDD123");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		session.setAttribute("user", null);
		session.setAttribute("userType", null);
		return "yes";
	}

	public String adminPwEdit(String userPwNew) {
		System.out.println("DDDD456");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		TAdmin admin = (TAdmin) session.getAttribute("admin");
		admin.setAdminPw(userPwNew);

		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);

		return "yes";
	}
	

	public String userPwEdit(String userPwOld, String userPwNew) {

		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		TUser user = (TUser) session.getAttribute("user");
		if (user == null) {
			return "LOGIN";
		}
		if (user.getUserPw().equals(userPwOld)) {
			user.setUserPw(userPwNew);
			userDAO.getHibernateTemplate().update(user);
			session.setAttribute("user", user);
			return "OK";
		} else {
			return "PWDERROR";
		}
	}
	
	
	
	
	public String userEdit(String userRealname,String userSex,String userAge,String userAddress,String userTel) {

		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		TUser user = (TUser) session.getAttribute("user");
		if (user == null) {
			return "LOGIN";
		}
		if (!StringUtils.isNull(userRealname)) {
			user.setUserRealname(userRealname);
		}
		
		
		if (!StringUtils.isNull(userSex)) {
			user.setUserSex(userSex);
		}
		

		if (!StringUtils.isNull(userAge)) {
			user.setUserAge(userAge);
		}
		

		if (!StringUtils.isNull(userAddress)) {
			user.setUserAddress(userAddress);
		}
		

		if (!StringUtils.isNull(userTel)) {
			user.setUserTel(userTel);
		}
		
		userDAO.getHibernateTemplate().update(user);
		session.setAttribute("user", user);
		return "OK";
	}	
	
	
	

}
