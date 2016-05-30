package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.TChuzuDAO;
import com.model.TChuzu;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.StringUtils;

public class chuzuAction extends ActionSupport
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

	private String fujian;
	private String zt;
	private String message;
	private String path;
	
	
	
	
	private TChuzuDAO chuzuDAO;
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


	public String chuzuAdd()
	{
		
        HttpServletRequest request=ServletActionContext.getRequest();
        
        Object userType = request.getSession().getAttribute("userType");
        if(userType!=null&&userType.equals(1)){
            //是管理员就写0,普通用户写1
        }else{
            return LOGIN;
        }

        TUser tuser=(TUser)(request.getSession().getAttribute("user"));
		  TChuzu chuzu=new TChuzu();
		
		
		
		
		chuzu.setHuxing(huxing);
		chuzu.setMianji(mianji);
		chuzu.setZhuangxiu(zhuangxiu);
		chuzu.setJiage(jiage);
		
		chuzu.setDizhi(dizhi);
		chuzu.setLianxiren(lianxiren);
		chuzu.setLianxihua(lianxihua);
		chuzu.setFujian(fujian);
		
		chuzu.setFabushi(new Date());
		chuzu.setZt("等待审核");
		chuzu.setTuser(tuser);
		
		chuzuDAO.save(chuzu);

		this.setMessage("信息发布完毕，等待管理员审核");
		this.setPath("chuzuMine.action");
		return "succeed";
	}
	
	
	public String chuzuMine()
	{

		HttpServletRequest request=ServletActionContext.getRequest();
		TUser user=(TUser)(request.getSession().getAttribute("user"));
		
		String sql="from TChuzu where user_id="+user.getUserId()+" order by fabushi desc";
		List chuzuList=chuzuDAO.getHibernateTemplate().find(sql);

		request.setAttribute("chuzuList", chuzuList);
		return ActionSupport.SUCCESS;
	
	}
	
	
	
	public String chuzuMana()
	{
		String sql="from TChuzu order by fabushi desc";
		List chuzuList=chuzuDAO.getHibernateTemplate().find(sql);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("chuzuList", chuzuList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	public String chuzuShenhe()
	{
		TChuzu chuzu=chuzuDAO.findById(id);
		chuzu.setZt(zt);
		chuzuDAO.attachDirty(chuzu);

		

		HttpServletRequest request=ServletActionContext.getRequest();
		if(!"0".equals( request.getSession().getAttribute("userType").toString())){
			
			return LOGIN;
		};
		
		
		request.setAttribute("msg", "信息审核完毕");
		
		return "msg";
	}
	
	
	
	
	
	public String chuzuDel()
	{
		TChuzu chuzu=chuzuDAO.findById(id);
		chuzuDAO.delete(chuzu);

		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.setAttribute("msg", "信息删除完毕");
		
		return "msg";
	}
	
	
	
	
	public String chuzuAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 10;
		}
		// 查11条数据
		// List chuzuList=chuzuDAO.findAll("from TChuzu where zt='审核通过'
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
		List chuzuList = chuzuDAO.findWithCondition(condition, first, max,"fabushi",false);//最新的 置顶
		// 是否有上一页
		request.setAttribute("prefirst", first > 9 ? first - 10 : 0);
		if (chuzuList.size() == 11) {
			// 还有下一页
			request.setAttribute("nextfirst", first + 10);
			chuzuList.remove(10);
		} else {
			// 没有有下一页
			request.setAttribute("nextfirst", first);
		}
		request.setAttribute("chuzuList", chuzuList);
		return ActionSupport.SUCCESS;

	}
	
	
	
	
	
	
	
	
	public String chuzuDetailQian()
	{
		TChuzu chuzu=chuzuDAO.findById(id);

		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("chuzu", chuzu);
		
		return ActionSupport.SUCCESS;
	}

	
	
	
	
	
	
	
	
	public String chuzuRes()
	{
		
		String sql="from TChuzu where huxing like '%"+huxing.trim()+"%'"+" and dizhi like '%"+dizhi.trim()+"%'";
		List chuzuList=chuzuDAO.getHibernateTemplate().find(sql);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		request.setAttribute("chuzuList", chuzuList);
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



	



	public TChuzuDAO getChuzuDAO()
	{
		return chuzuDAO;
	}


	public void setChuzuDAO(TChuzuDAO chuzuDAO)
	{
		this.chuzuDAO = chuzuDAO;
	}


	public String getFujian()
	{
		return fujian;
	}


	public void setFujian(String fujian)
	{
		this.fujian = fujian;
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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
}
