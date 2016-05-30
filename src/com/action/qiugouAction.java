package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.dao.TQiugouDAO;
import com.model.TQiugou;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.StringUtils;

public class qiugouAction extends ActionSupport
{
	
	
	private Integer id;
	private Integer userId;
	
	private String huxing;
	private int mianji;
	private String zhuangxiu;

	private int jiage;
	private String dizhi;
	private String lianxiren;
	private String lianxihua;

	private String zt;

	
	
	
	private TQiugouDAO qiugouDAO;
	private int first;
	private int max;
	
	
	
	
	
	
	public int getFirst() {
		return first;
	}


	public void setFirst(int first) {
		this.first = first;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public String qiugouAdd()
	{
		
        HttpServletRequest request=ServletActionContext.getRequest();
        
        Object userType = request.getSession().getAttribute("userType");
        if(userType!=null&&userType.equals(1)){
            //是管理员就写0,普通用户写1
        }else{
            return LOGIN;
        }

        TUser tuser=(TUser)(request.getSession().getAttribute("user"));
		  TQiugou qiugou=new TQiugou();
		
		
		
		
		qiugou.setHuxing(huxing);
		qiugou.setMianji(mianji);
		qiugou.setZhuangxiu(zhuangxiu);
		qiugou.setJiage(jiage);
		
		qiugou.setDizhi(dizhi);
		qiugou.setLianxiren(lianxiren);
		qiugou.setLianxihua(lianxihua);
		
		
		qiugou.setFabushi(new Date());
		qiugou.setZt("等待审核");
		qiugou.setTuser(tuser);
		
		qiugouDAO.save(qiugou);
		request.setAttribute("msg", "信息发布完毕，等待管理员审核");
		
		return "msg";
	}
	
	
	public String qiugouMine()
	{

		HttpServletRequest request=ServletActionContext.getRequest();
		TUser user=(TUser)(request.getSession().getAttribute("user"));
		
		String sql="from TQiugou where user_id="+user.getUserId()+" order by fabushi desc";
		List qiugouList=qiugouDAO.getHibernateTemplate().find(sql);

		request.setAttribute("qiugouList", qiugouList);
		return ActionSupport.SUCCESS;
	
	}
	
	
	
	public String qiugouMana()
	{
//		String sql="from TQiugou order by fabushi desc";
//		List qiugouList=qiugouDAO.getHibernateTemplate().find(sql);
//		
//		
//		HttpServletRequest request=ServletActionContext.getRequest();
//		
//		
//		request.setAttribute("qiugouList", qiugouList);
//		return ActionSupport.SUCCESS;
		HttpServletRequest request = ServletActionContext.getRequest();
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 10;
		}
		Map<String, String[]> condition = new HashMap<String, String[]>();
		List qiugouList = qiugouDAO.findWithCondition(condition, first, max+1,"fabushi",false);//最新的 置顶
		// 是否有上一页
		request.setAttribute("prefirst", first > 9 ? first - 10 : 0);
		if (qiugouList.size() == max+1) {
			// 还有下一页
			request.setAttribute("nextfirst", first + max);
			qiugouList.remove(max);
		} else {
			// 没有有下一页
			request.setAttribute("nextfirst", first);
		}
		request.setAttribute("qiugouList", qiugouList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	public String qiugouShenhe()
	{
		TQiugou qiugou=qiugouDAO.findById(id);
		qiugou.setZt(zt);
		qiugouDAO.attachDirty(qiugou);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		if(!"0".equals( request.getSession().getAttribute("userType").toString())){
			
			return LOGIN;
		};
		
		request.setAttribute("msg", "信息审核完毕");
		
		return "msg";
	}
	
	
	
	
	
	public String qiugouDel()
	{
		TQiugou qiugou=qiugouDAO.findById(id);
		qiugouDAO.delete(qiugou);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("msg", "信息删除完毕");
		
		return "msg";
	}
	
	
	
	
	public String qiugouAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 10;
		}
		// 查11条数据
		// List chuzuList=qiugouDAO.findAll("from TQiugou where zt='审核通过'
		// order by fabushi desc",first, max+1);
		Map<String, String[]> condition = new HashMap<String, String[]>();
		condition.put("zt", new String[] { "审核通过", "equals" });
		if (!StringUtils.isNull(huxing)) {
			condition.put("huxing", new String[] { huxing, "like" });
		}
		
		if (!StringUtils.isNull(zhuangxiu)) {
			condition.put("zhuangxiu", new String[] { zhuangxiu, "like" });
		}
		if (!StringUtils.isNull(dizhi)) {
			condition.put("dizhi", new String[] { dizhi, "like" });
		}
		List qiugouList = qiugouDAO.findWithCondition(condition, first, max+1,"fabushi",false);//最新的 置顶
		// 是否有上一页
		request.setAttribute("prefirst", first > 9 ? first - 10 : 0);
		if (qiugouList.size() == max+1) {
			// 还有下一页
			request.setAttribute("nextfirst", first + max);
			qiugouList.remove(10);
		} else {
			// 没有有下一页
			request.setAttribute("nextfirst", first);
		}
		request.setAttribute("qiugouList", qiugouList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	
	
	public String qiugouDetailQian()
	{
		TQiugou qiugou=qiugouDAO.findById(id);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("qiugou", qiugou);
		
		return ActionSupport.SUCCESS;
	}

	
	
	
	
	
	
	
	
	public String qiugouRes()
	{
		
		String sql="from TQiugou where huxing like '%"+huxing.trim()+"%'"+" and dizhi like '%"+dizhi.trim()+"%'";
		List qiugouList=qiugouDAO.getHibernateTemplate().find(sql);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("qiugouList", qiugouList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	

	public String getDizhi()
	{
		return dizhi;
	}


	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}



	



	public TQiugouDAO getQiugouDAO()
	{
		return qiugouDAO;
	}


	public void setQiugouDAO(TQiugouDAO qiugouDAO)
	{
		this.qiugouDAO = qiugouDAO;
	}




	public String getHuxing()
	{
		return huxing;
	}


	public void setHuxing(String huxing)
	{
		this.huxing = huxing;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getLianxihua()
	{
		return lianxihua;
	}


	public void setLianxihua(String lianxihua)
	{
		this.lianxihua = lianxihua;
	}


	public String getLianxiren()
	{
		return lianxiren;
	}


	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}



	


	public int getJiage()
	{
		return jiage;
	}


	public void setJiage(int jiage)
	{
		this.jiage = jiage;
	}


	public int getMianji()
	{
		return mianji;
	}


	public void setMianji(int mianji)
	{
		this.mianji = mianji;
	}


	public String getZhuangxiu()
	{
		return zhuangxiu;
	}


	public void setZhuangxiu(String zhuangxiu)
	{
		this.zhuangxiu = zhuangxiu;
	}


	public String getZt()
	{
		return zt;
	}


	public void setZt(String zt)
	{
		this.zt = zt;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
