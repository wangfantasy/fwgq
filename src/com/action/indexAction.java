package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TChushouDAO;
import com.dao.TChuzuDAO;
import com.dao.TQiugouDAO;
import com.dao.TQiuzuDAO;
import com.opensymphony.xwork2.ActionSupport;


public class indexAction extends ActionSupport
{
	private TChushouDAO chushouDAO;
	private TChuzuDAO chuzuDAO;
	private TQiugouDAO qiugouDAO;
	private TQiuzuDAO qiuzuDAO;
	
	public String index()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map condition=new HashMap();
		condition.put("zt", new String[]{"审核通过","equals"});
		List chushouList=chushouDAO.findWithCondition(condition, 0, 5,"fabushi",true);
		List chuzuList=chuzuDAO.findWithCondition(condition, 0, 5,"fabushi",false);
		List qiugouList=qiugouDAO.findWithCondition(condition, 0, 5,"fabushi",false);//最新的 置顶
		List qiuzuList=qiuzuDAO.findWithCondition(condition, 0, 5,"fabushi",false);
		request.setAttribute("chushouList", chushouList);
		request.setAttribute("chuzuList", chuzuList);
		request.setAttribute("qiugouList", qiugouList);
		request.setAttribute("qiuzuList", qiuzuList);
		
		
		return ActionSupport.SUCCESS;
	}

	public TChushouDAO getChushouDAO() {
		return chushouDAO;
	}

	public void setChushouDAO(TChushouDAO chushouDAO) {
		this.chushouDAO = chushouDAO;
	}

	public TChuzuDAO getChuzuDAO() {
		return chuzuDAO;
	}

	public void setChuzuDAO(TChuzuDAO chuzuDAO) {
		this.chuzuDAO = chuzuDAO;
	}

	public TQiugouDAO getQiugouDAO() {
		return qiugouDAO;
	}

	public void setQiugouDAO(TQiugouDAO qiugouDAO) {
		this.qiugouDAO = qiugouDAO;
	}

	public TQiuzuDAO getQiuzuDAO() {
		return qiuzuDAO;
	}

	public void setQiuzuDAO(TQiuzuDAO qiuzuDAO) {
		this.qiuzuDAO = qiuzuDAO;
	}

}
