package com.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.TChushouDAO;
import com.model.TChushou;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.StringUtils;

public class chushouAction extends ActionSupport {

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

	private TChushouDAO chushouDAO;
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

	public String chushouAdd() {

		HttpServletRequest request = ServletActionContext.getRequest();

		Object userType = request.getSession().getAttribute("userType");
		if (userType != null && userType.equals(1)) {
			// �ǹ���Ա��д0,��ͨ�û�д1
		} else {
			return LOGIN;
		}

		TUser tuser = (TUser) (request.getSession().getAttribute("user"));
		TChushou chushou = new TChushou();

		chushou.setHuxing(huxing);
		chushou.setMianji(mianji);
		chushou.setZhuangxiu(zhuangxiu);
		chushou.setJiage(jiage);

		chushou.setDizhi(dizhi);
		chushou.setLianxiren(lianxiren);
		chushou.setLianxihua(lianxihua);
		chushou.setFujian(fujian);

		chushou.setFabushi(new Date()); 
		// new SimpleDateFormat("yyyy-MM-dd").format(new Date())
		

		// new Date().toLocaleString()

		chushou.setZt("�ȴ����");
		chushou.setTuser(tuser);

		chushouDAO.save(chushou);

		this.setMessage("��Ϣ������ϣ��ȴ�����Ա���");
		this.setPath("chushouMine.action");
		return "succeed";

	}

	public String chushouMine() {

		HttpServletRequest request = ServletActionContext.getRequest();
		TUser user = (TUser) (request.getSession().getAttribute("user"));

		String sql = "from TChushou where user_id=" + user.getUserId()
				+ " order by fabushi desc";
		List chushouList = chushouDAO.getHibernateTemplate().find(sql);

		request.setAttribute("chushouList", chushouList);
		return ActionSupport.SUCCESS;

	}

	public String chushouMana() {
		String sql = "from TChushou order by fabushi desc";
		List chushouList = chushouDAO.getHibernateTemplate().find(sql);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("chushouList", chushouList);
		return ActionSupport.SUCCESS;
	}

	public String chushouShenhe() {
		TChushou chushou = chushouDAO.findById(id);
		chushou.setZt(zt);
		chushouDAO.attachDirty(chushou);


		HttpServletRequest request=ServletActionContext.getRequest();
		if(!"0".equals( request.getSession().getAttribute("userType").toString())){
			
			return LOGIN;
		};

		request.setAttribute("msg", "��Ϣ������");

		return "msg";
	}

	public String chushouDel() {
		TChushou chushou = chushouDAO.findById(id);
		chushouDAO.delete(chushou);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("msg", "��Ϣɾ�����");

		return "msg";
	}

	public String chushouAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (first < 0) {
			first = 0;
		}
		if (max < 0) {
			max = 10;
		}
		// ��11������
		// List chushouList=chushouDAO.findAll("from TChushou where zt='���ͨ��'
		// order by fabushi desc",first, max+1);
		Map<String, String[]> condition = new HashMap<String, String[]>();
		condition.put("zt", new String[] { "���ͨ��", "equals" });
		if (!StringUtils.isNull(huxing)) {
			condition.put("huxing", new String[] { huxing, "like" });
		}
		
		if (!StringUtils.isNull(zhuangxiu)) {
			condition.put("zhuangxiu", new String[] { zhuangxiu, "like" });
		}
		if (!StringUtils.isNull(dizhi)) {
			condition.put("dizhi", new String[] { dizhi, "like" });
		}
		List chushouList = chushouDAO.findWithCondition(condition, first, max,"fabushi",false);//���µ� �ö�
		// �Ƿ�����һҳ
		request.setAttribute("prefirst", first > 9 ? first - 10 : 0);
		if (chushouList.size() == 11) {
			// ������һҳ
			request.setAttribute("nextfirst", first + 10);
			chushouList.remove(10);
		} else {
			// û������һҳ
			request.setAttribute("nextfirst", first);
		}
		request.setAttribute("chushouList", chushouList);
		return ActionSupport.SUCCESS;


	}

	public String chushouDetailQian() {
		TChushou chushou = chushouDAO.findById(id);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("chushou", chushou);

		return ActionSupport.SUCCESS;
	}

	public String chushouRes() {

		String sql = "from TChushou where huxing like '%" + huxing.trim()
				+ "%'" + " and dizhi like '%" + dizhi.trim() + "%'";
		List chushouList = chushouDAO.getHibernateTemplate().find(sql);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("chushouList", chushouList);
		return ActionSupport.SUCCESS;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public TChushouDAO getChushouDAO() {
		return chushouDAO;
	}

	public void setChushouDAO(TChushouDAO chushouDAO) {
		this.chushouDAO = chushouDAO;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public String getHuxing() {
		return huxing;
	}

	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLianxihua() {
		return lianxihua;
	}

	public void setLianxihua(String lianxihua) {
		this.lianxihua = lianxihua;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public int getJiage() {
		return jiage;
	}

	public void setJiage(int jiage) {
		this.jiage = jiage;
	}

	public int getMianji() {
		return mianji;
	}

	public void setMianji(int mianji) {
		this.mianji = mianji;
	}

	public String getZhuangxiu() {
		return zhuangxiu;
	}

	public void setZhuangxiu(String zhuangxiu) {
		this.zhuangxiu = zhuangxiu;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
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
