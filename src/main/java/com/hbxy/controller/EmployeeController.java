package com.hbxy.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hbxy.bean.Page;
import com.hbxy.common.Constant;
import com.hbxy.service.ChargeStandardService;
import com.hbxy.service.EmployeeService;
import com.hbxy.service.RoomService;
import com.hbxy.service.RoomTypeService;
import com.hbxy.util.DateUtil;
import com.hbxy.util.PageData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("employee")
public class EmployeeController extends BaseController
{
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomTypeService roomTypeService;

	@Autowired
	private ChargeStandardService chargeStandardService;

	/**
	 * 住宿办理/首页
	 * @return
	 */
	@RequestMapping("toMenuIndex")
	public String toMenuIndex()
	{
		return "housing/menu_index";
	}

	/**
	 * 入住办理
	 * @return
	 */
	@RequestMapping("toIndex")
	public String toIndex()
	{
		return "housing/index";
	}
	
	@RequestMapping("toDefault")
	public String toDefault()
	{
		return "housing/default";
	}

	/**
	 * 查询入住人员信息
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(Page page)
	{
		PageData pd = this.getPageData();
		page.setPd(pd); 
		
		List<PageData> list;
		ModelAndView mv = this.getModelAndView();
		try
		{
			double money = 0;
			list = employeeService.datalistPage(page);
			for(int i = 0; i < list.size(); i++)
			{
				PageData pageData = list.get(i);
				
				Calendar outCalendar = Calendar.getInstance();
				outCalendar.setTime(new Date());
				
				String payTime = pageData.getString("payTime"); 
				Calendar paymentCalendar = Calendar.getInstance();
				paymentCalendar.setTime(DateUtil.str2Date(payTime));
				
				//交租日期
				long startTime = paymentCalendar.getTimeInMillis();
				long endTime = outCalendar.getTimeInMillis();
				long days = (endTime - startTime) / (1000 * 3600 * 24);
				String roomTypeId = roomService.findById(pageData).get("roomTypeId").toString();
				if("1".equals(roomTypeId))
				{
					pageData.put("csId", "8");
				}
				else if("2".equals(roomTypeId))
				{
					pageData.put("csId", "7");
				}
				else if("3".equals(roomTypeId))
				{
					pageData.put("csId", "8");
				}
				else if("4".equals(roomTypeId))
				{
					pageData.put("csId", "9");
				}
				else if("5".equals(roomTypeId))
				{
					pageData.put("csId", "6");
				}
				
				double price  = (double) chargeStandardService.findById(pageData).get("csPrice");

				money = days * price;

				money = (double) chargeStandardService.findById(pageData).get("csPrice") - money;
				
				list.get(i).put("price", money);
				
			}
			
			mv.addObject("varList", list);
			mv.setViewName("housing/quit_list");
			mv.addObject("msg", "list");
			mv.addObject("pd", pd);
			
		} catch (Exception e)
		{
			mv.addObject("msg", Constant.AJAX_FAIL);
			e.printStackTrace();
		}
		
		return mv;
	}

	/**
	 * 保存入住人员资料
	 * @return
	 */
	@RequestMapping("saveEmployee")
	@ResponseBody
	public String saveEmployee()
	{
		PageData pd = this.getPageData();
		
		String time = pd.getString("enterTime");
		if (StringUtils.isNotEmpty(time))
		{
			Date date = DateUtil.str2Date(time);
			//初始化日历对象
			Calendar calendar = Calendar.getInstance();
			Calendar payCanlendar = Calendar.getInstance();
			Calendar wePayCalendar = Calendar.getInstance();
			//把日历定到date
			calendar.setTime(date);
			payCanlendar.setTime(calendar.getTime());
			wePayCalendar.setTime(calendar.getTime());
			//当前日期+1月
			payCanlendar.add(Calendar.MONTH, 1);
			//当前日期+1月-1天
			wePayCalendar.set(Calendar.DAY_OF_MONTH, wePayCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			
			//入住日期大于下月最后一天，交租日期为下月最后一天
			if(calendar.get(Calendar.DAY_OF_MONTH) > payCanlendar.getActualMaximum(Calendar.DAY_OF_MONTH))
			{
				calendar.add(Calendar.MONTH, 1);
			}
			else
			{
				//入住日期一个月月后的前一天
				calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
			}
			
			pd.put("payTime", time);
			pd.put("nextPayTime", DateUtil.date2Str(calendar.getTime()));
			pd.put("wePayTime", DateUtil.date2Str(wePayCalendar.getTime(), "yyyy-MM"));
			pd.put("deleteFlag", 0);
			
		}
		
		try
		{
			employeeService.save(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return Constant.AJAX_SUCCESS;
	}

	/**
	 * 查询房间入住情况
	 * @return
	 */
	@RequestMapping("findRoom")
	@ResponseBody
	public Object findRoom()
	{
		PageData pd = this.getPageData();
		List<PageData> list;
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			PageData roomType = roomTypeService.findById(pd);
			if(roomType != null)
			{
				pd.put("total", roomType.get("amount"));
				
				list = roomService.findByRoomType(pd);
				map.put("varList", list);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return JSONUtils.toJSONString(map);
	}

	/**
	 * 退房
	 * @return
	 */
	@RequestMapping("quitHousing")
	@ResponseBody
	public String quitHousing()
	{
		PageData pd = this.getPageData();
		String leaveTime = DateUtil.date2Str(new Date());
		try
		{
			PageData empPd = employeeService.findById(pd);
			empPd.put("leaveTime", leaveTime);
			roomService.deleteEmployeeById(empPd);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		return Constant.AJAX_SUCCESS;
	}

	/**
	 * 人员信息
	 * @param page
	 * @return
	 */
	@RequestMapping("empList")
	public ModelAndView empList(Page page)
	{
		PageData pd = this.getPageData();
		page.setPd(pd); 
		
		List<PageData> list = null;
		ModelAndView mv = this.getModelAndView();
		try
		{
			list = employeeService.findAlllistPage(page);
			
		} catch (Exception e)
		{
			mv.addObject("msg", Constant.AJAX_FAIL);
			e.printStackTrace();
		}
		
		mv.addObject("varList", list);
		mv.setViewName("housing/emp_list");
		mv.addObject("msg", "empList");
		mv.addObject("pd", pd);
		
		return mv;
	}

	/**
	 * 展示修改的人员信息
	 * @return
	 */
	@RequestMapping("goEmployeeEdit")
	public ModelAndView goEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = employeeService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("msg", "empEdit");
		mv.setViewName("housing/employee_edit");
		return mv;
	}

	/**
	 * 修改人员信息
	 * @return
	 */
	@RequestMapping("empEdit")
	public ModelAndView empEdit()
	{
	PageData pd = this.getPageData();
	
	try
	{
		employeeService.updateEmpById(pd);
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	ModelAndView mv = this.getModelAndView();
	mv.addObject("msg", "empList");
	mv.setViewName("employee/employee_index");
	return mv;
	}
}
