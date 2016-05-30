package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    private Integer userId;
	private String userName;
	private String userPw;
	
	private String userRealname;
	private String userSex;
	private String userAge;
	private String userAddress;
	private String userTel;
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	
	public String userReg()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String sql="from TUser where userName=?";
		Object[] c={userName.trim()};
		List userList=userDAO.getHibernateTemplate().find(sql,c);
		if(userList.size()>0)
		{
			this.setMessage("账号已被占用，请重新注册");
			this.setPath("qiantai/userreg/userreg.jsp");
			return "succeed";
		}
		else
		{
			TUser user=new TUser();
			user.setUserName(userName);
			user.setUserPw(userPw);
			user.setUserRealname(userRealname);
			user.setUserSex(userSex);
			user.setUserAge(userAge);
			user.setUserAddress(userAddress);
			user.setUserTel(userTel);
			user.setUserDel("no");
			userDAO.save(user);
			this.setMessage("注册成功，请登录");
			this.setPath("index.action");
			return "succeed";
		}
	}
		
	
	
	public String userEdit()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		//user.setUserName(userName);
		user.setUserPw(userPw);
		
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		user.setUserAge(userAge);
		
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		
		userDAO.attachDirty(user);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("msg", "修改成功");
		
		return "msg";
	}
	
	
	
	public String userMana()
	{
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	
	
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public String getUserAge()
	{
		return userAge;
	}
	public void setUserAge(String userAge)
	{
		this.userAge = userAge;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	
	
	
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPw()
	{
		return userPw;
	}
	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public String getUserRealname()
	{
		return userRealname;
	}
	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}
	public String getUserSex()
	{
		return userSex;
	}
	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
		
}
