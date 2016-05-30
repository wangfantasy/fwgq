package com.action;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TQiuzuDAO;

import com.model.TQiugou;
import com.model.TQiuzu;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagesize;
import com.util.Pagination;
import com.util.StringUtils;

public class qiuzuAction extends ActionSupport
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
	
	private TQiuzuDAO qiuzuDAO;
	
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


	public String qiuzuAdd()
	{
		//这个方法需要什么权限需要普通用户权限就写1,需要管理员就写0
        HttpServletRequest request=ServletActionContext.getRequest();
        Object userType = request.getSession().getAttribute("userType");
        if(userType!=null&&userType.equals(1)){
            //是管理员就写0,普通用户写1
        }else{
            return LOGIN;
        }
        
		
		TUser tuser=(TUser)(request.getSession().getAttribute("user"));
		  TQiuzu qiuzu=new TQiuzu();
		
		
		qiuzu.setHuxing(huxing);
		qiuzu.setMianji(mianji);
		qiuzu.setZhuangxiu(zhuangxiu);
		qiuzu.setJiage(jiage);
		
		qiuzu.setDizhi(dizhi);
		qiuzu.setLianxiren(lianxiren);
		qiuzu.setLianxihua(lianxihua);
		
		qiuzu.setFabushi(new Date());
		qiuzu.setZt("等待审核");
		qiuzu.setTuser(tuser);
		
		
		qiuzuDAO.save(qiuzu);
		request.setAttribute("msg", "信息发布完毕，等待管理员审核");
		
		return "msg";
	}
	
	
	public String qiuzuMine()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		TUser user=(TUser)(request.getSession().getAttribute("user"));
		
		String sql="from TQiuzu where user_id="+user.getUserId()+" order by fabushi desc";
		List qiuzuList=qiuzuDAO.getHibernateTemplate().find(sql);
		
		request.setAttribute("qiuzuList", qiuzuList);
		return ActionSupport.SUCCESS;
	}
	
	public String qiuzuMana()
	{
		String sql="from TQiuzu order by fabushi desc";
		List qiuzuList=qiuzuDAO.getHibernateTemplate().find(sql);
		
		//这个方法需要什么权限?需要普通用户权限就写1,需要管理员就写0
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("qiuzuList", qiuzuList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String qiuzuShenhe()
	{
		TQiuzu qiuzu=qiuzuDAO.findById(id);
		qiuzu.setZt(zt);
		qiuzuDAO.attachDirty(qiuzu);

		//这个方法需要什么权限?需要普通用户权限就写1,需要管理员就写0
		HttpServletRequest request=ServletActionContext.getRequest();
		if(!"0".equals( request.getSession().getAttribute("userType").toString())){
			//不是管理员
			return LOGIN;
		};
		
		request.setAttribute("msg", "信息审核完毕");
		
		return "msg";
	}
	
	
	
	public String qiuzuDel()
	{
		TQiuzu qiuzu=qiuzuDAO.findById(id);
		qiuzuDAO.delete(qiuzu);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("msg", "信息删除完毕");
		
		return "msg";
	}
	
	
	public String qiuzuAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 10;
		}
		// 查11条数据
		// List qiuzuList=qiuzuDAO.findAll("from TQiuzu where zt='审核通过'
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
		List qiuzuList = qiuzuDAO.findWithCondition(condition, first, max,"fabushi",false);//最新的 置顶
		// 是否有上一页
		request.setAttribute("prefirst", first > 9 ? first - 10 : 0);
		if (qiuzuList.size() == 11) {
			// 还有下一页
			request.setAttribute("nextfirst", first + 10);
			qiuzuList.remove(10);
		} else {
			// 没有有下一页
			request.setAttribute("nextfirst", first);
		}
		request.setAttribute("qiuzuList", qiuzuList);
		return ActionSupport.SUCCESS;

	}
	
	
	
	public String qiuzuDetailQian()
	{
		TQiuzu qiuzu=qiuzuDAO.findById(id);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("qiuzu", qiuzu);
		
		return ActionSupport.SUCCESS;
	}

	
	public String qiuzuRes()
	{
		
		String sql="from TQiuzu where huxing like '%"+huxing.trim()+"%'"+" and dizhi like '%"+dizhi.trim()+"%'";
		List qiuzuList=qiuzuDAO.getHibernateTemplate().find(sql);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("qiuzuList", qiuzuList);
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


	public TQiuzuDAO getQiuzuDAO()
	{
		return qiuzuDAO;
	}


	public void setQiuzuDAO(TQiuzuDAO qiuzuDAO)
	{
		this.qiuzuDAO = qiuzuDAO;
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
