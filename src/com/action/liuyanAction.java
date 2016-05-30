package com.action;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.dao.TLiuyanDAO;
import com.model.TUser;
import com.model.TLiuyan;
import com.opensymphony.xwork2.ActionSupport;

public class liuyanAction extends ActionSupport
{
	private int liuyanId;
	private Integer userId;
	
	private String liuyanTitle;
	private String liuyanContent;
	private Date liuyanDate;
	
	
	private String huifuContent;
	
	private String message;
	private String path;
	
	private TLiuyanDAO liuyanDAO;
	
	public String liuyanAdd()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		TUser user=(TUser) session.getAttribute("user");
		if(user==null){
			return LOGIN;
		}
		TLiuyan liuyan=new TLiuyan();
		liuyan.setLiuyanTitle(liuyanTitle);
		liuyan.setLiuyanContent(liuyanContent);
		liuyan.setLiuyanDate(new Date());
		liuyanDAO.save(user,liuyan);
		this.setMessage("信息添加完毕");
		this.setPath("liuyanMine.action");
		return "succeed";
	}
	
	public String huifuAdd()
	{
		System.out.println("huifuContent"+huifuContent);
		System.out.println("liuyanId"+liuyanId);
		TLiuyan liuyan=new TLiuyan();
		liuyan.setLiuyanId(liuyanId);
		liuyan.setHuifuContent(huifuContent);
		liuyan.setHuifuDate(new Date());
		liuyanDAO.save(liuyan);
		this.setMessage("回复信息添加完毕");
		this.setPath("liuyanMana.action");
		return "succeed";
	}
	
	
	public String liuyanMine()
	{
		String sql="from TLiuyan order by liuyanDate desc";
		List liuyanList=liuyanDAO.getHibernateTemplate().find(sql);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	public String huifuEdit()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("liuyanId", liuyanId);
		return ActionSupport.SUCCESS;
	}
	
	public String liuyanMana()
	{
		String sql="from TLiuyan order by liuyanDate desc";
		List liuyanList=liuyanDAO.getHibernateTemplate().find(sql);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String adminliuyanDel()
	{

		
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		liuyanDAO.delete(liuyan);
		this.setMessage("信息删除完毕");
		this.setPath("liuyanMana.action");
		return "succeed";
	}
	
	
	public String liuyanDel()
	{

		
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		liuyanDAO.delete(liuyan);
		this.setMessage("信息删除完毕");
		this.setPath("liuyanMine.action");
		return "succeed";
	}
	
	
	public String liuyanDetail()
	{
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyan", liuyan);
		return ActionSupport.SUCCESS;
	}
	
	public String huifuDetail()
	{
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyan", liuyan);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String liuyanDetailQian()
	{
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		System.out.println(liuyan.getLiuyanDate());
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyan", liuyan);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String liuyanAll()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		List liuyanList=liuyanDAO.findAll();
		request.put("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}

	public String getLiuyanContent()
	{
		return liuyanContent;
	}

	public void setLiuyanContent(String liuyanContent)
	{
		this.liuyanContent = liuyanContent;
	}


	public TLiuyanDAO getLiuyanDAO()
	{
		return liuyanDAO;
	}

	public void setLiuyanDAO(TLiuyanDAO liuyanDAO)
	{
		this.liuyanDAO = liuyanDAO;
		System.out.println(this.getClass().getName()+".setLiuyanDAO");
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLiuyanDate() {
		return liuyanDate;
	}

	public void setLiuyanDate(Date liuyanDate) {
		this.liuyanDate = liuyanDate;
	}

	public int getLiuyanId()
	{
		return liuyanId;
	}

	public void setLiuyanId(int liuyanId)
	{
		this.liuyanId = liuyanId;
	}

	public String getLiuyanTitle()
	{
		return liuyanTitle;
	}

	public void setLiuyanTitle(String liuyanTitle)
	{
		this.liuyanTitle = liuyanTitle;
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

	public String getHuifuContent() {
		return huifuContent;
	}

	public void setHuifuContent(String huifuContent) {
		this.huifuContent = huifuContent;
	}
	
}
