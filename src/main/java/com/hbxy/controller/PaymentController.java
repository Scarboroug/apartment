package com.hbxy.controller;

import com.hbxy.bean.Page;
import com.hbxy.common.Constant;
import com.hbxy.service.ChargeStandardService;
import com.hbxy.service.EmployeeService;
import com.hbxy.service.PaymentService;
import com.hbxy.util.DateUtil;
import com.hbxy.util.PageData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("payment")
public class PaymentController extends BaseController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ChargeStandardService chargeStandardService;
	
	@Autowired
	private EmployeeService employeeService;

	/**
     * 缴费管理
     * @return
     */
	@RequestMapping("toMenuIndex")
	public ModelAndView toMenuIndex() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("payment/menu_index");
		return mv;
	}

	/**
	 * 房租缴费列表
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(Page page) {
		PageData pd = this.getPageData();

		page.setPd(pd);
		
		List<PageData> list = new ArrayList<PageData>();
		try {
			list = paymentService.findRentlistPage(page);
			for (PageData result:list){
				Map map = new HashMap();
				String nextPayTime = result.getString("nextPayTime");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(DateUtil.dateBetweenIncludeToday(sdf.parse(nextPayTime),sdf.parse(sdf.format(new Date()))) > 0){
					map.put("state","1");
				}else {
					map.put("state","2");
				}
				result.putAll(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		ModelAndView mv = this.getModelAndView();
		mv.addObject("varList", list);
		mv.addObject("msg", "list");
		mv.addObject("pd", pd);
		mv.setViewName("payment/payment_rent");
		return mv;
	}

	/**
	 * 水电缴费列表
	 * @param page
	 * @return
	 */
	@RequestMapping("weList")
	public ModelAndView weList(Page page) {
		PageData pd = this.getPageData();
		if(StringUtils.isEmpty(pd.getString("time"))) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);
			pd.put("time", DateUtil.date2Str(calendar.getTime(), "yyyy-MM"));
		}
		page.setPd(pd);
		
		List<PageData> list = new ArrayList<PageData>();
		try {
			list = paymentService.listPage(page);
			if(list != null) {
				for(int i = 0; i < list.size(); i++) {
					PageData pageData = list.get(i);
					pageData.put("price", getPrice(pageData));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("payment/payment_we");
		mv.addObject("msg", "weList");
		mv.addObject("varList", list);
		mv.addObject("pd", pd);
		return mv;
	}
	
	public double getPrice(PageData pd) {
		long count = 0;
		double price = 0;
		long days = 0;
		long day = 0;
		try {
			//通过id获取指定房间指定时间还没有交水电费人员信息
			List<PageData> list = paymentService.findEmpByRoomId(pd);
			if(list != null) {
				String time = pd.getString("time");
				String empId = "";
				//指定月份1号开始
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(DateUtil.str2Date(time + "-01"));
				for(int i = 0; i < list.size(); i++) {
					//获取指定月份当月天数
					days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					PageData pageData = list.get(i);
					empId = pageData.get("empId").toString();
					String enterTime = pageData.getString("enterTime");
					Calendar enterCalendar = Calendar.getInstance();
					enterCalendar.setTime(DateUtil.str2Date(enterTime));
					long enterDays = (enterCalendar.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
					//判断是否当月入住
					if(enterDays > 0) {
						//当月入住者居住时长
						days = days - enterDays;
					}
					//获取人员入住总天数
					count = Long.parseLong(pageData.get("days").toString());
					//确定本人入住时长
					if(pd.get("empId").toString().equals(empId)) {
						day = days;
					}
				}
				double waterStandard = 0;
				double electricStandard = 0;
				double water = (double) pd.get("water");
				double electric = (double) pd.get("electric");
				PageData csPd = new PageData();
				PageData wPd = new PageData();
				PageData ePd = new PageData();
				csPd.put("csId", 3);
				wPd = chargeStandardService.findById(csPd);
				if(wPd != null) {
					waterStandard = (double) wPd.get("csPrice");
				}
				csPd.put("csId", 2);
				ePd = chargeStandardService.findById(csPd);
				if(ePd != null) {
					electricStandard = (double) ePd.get("csPrice");
				}
				price = (water * waterStandard + electric * electricStandard) / count * day;
				//四舍五入
				price = new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

	/**
	 * 缴费水电
	 * @return
	 */
	@RequestMapping("payWE")
	@ResponseBody
	public String payWE() {
		PageData pd = this.getPageData();
		try {
		    String price = pd.getString("price");
			pd = employeeService.findById(pd);
			
			String wePayTime = pd.getString("wePayTime");
			Calendar weCalendar = Calendar.getInstance();
			weCalendar.setTime(DateUtil.str2Date(wePayTime, "yyyy-MM"));
			weCalendar.add(Calendar.MONTH, 1);
			
			pd.put("wePayTime", DateUtil.date2Str(weCalendar.getTime(), "yyyy-MM"));
			pd.put("price", price);
			employeeService.updateWEPayTimeById(pd);

		} catch (Exception e) {
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return Constant.AJAX_SUCCESS;
	}

	/**
	 * 缴费房租
	 * @return
	 */
	@RequestMapping("payRental")
	@ResponseBody
	public Object payRental() {
		PageData pd = this.getPageData();
		try {
			//查询交租人员信息
			pd = employeeService.findById(pd);
			String enterTime = pd.getString("enterTime");
			String payTime = pd.getString("nextPayTime") ;
			//根据入住时间，计算下次交租时间
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateUtil.str2Date(payTime));
			calendar.add(Calendar.MONTH, 1);
			Calendar enterCalendar = Calendar.getInstance();
			enterCalendar.setTime(DateUtil.str2Date(enterTime));
			//入住日期大于下月最后一天，交租日期为下月最后一天
			if(enterCalendar.get(Calendar.DAY_OF_MONTH) <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				calendar.set(Calendar.DAY_OF_MONTH, enterCalendar.get(Calendar.DAY_OF_MONTH) - 1);
			} else {
				calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			}
			PageData pageData = new PageData();
			pageData.put("payTime", payTime);
			//次月交租日期更新为最新交租时间
			pageData.put("nextPayTime", DateUtil.date2Str(calendar.getTime()));
			pageData.put("empId", pd.get("empId").toString());
			//进行更新操作
			employeeService.updateEmpById(pageData);
			
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return Constant.AJAX_SUCCESS;
	}

}
