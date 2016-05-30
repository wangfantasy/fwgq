package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport{
	public String exit(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("userType");
		return ActionSupport.SUCCESS;
	}
}
