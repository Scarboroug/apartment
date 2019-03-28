package com.hbxy.action;

import com.hbxy.bean.Page;
import com.hbxy.common.Constant;
import com.hbxy.service.DataEntryService;
import com.hbxy.service.EmployeeService;
import com.hbxy.service.PaymentService;
import com.hbxy.service.RoomService;
import com.hbxy.util.DateUtil;
import com.hbxy.util.PageData;
import com.hbxy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("dataEntry")
public class DataEntryAction extends BaseAction
{
	@Resource(name = "dataEntry")
	DataEntryService dataEntryService;
	
	@Resource(name = "roomService")
	RoomService RoomService;
	
	@Resource(name = "paymentService")
	PaymentService paymentService;
	
	@Resource(name = "employeeService")
	EmployeeService employeeService;
	
	@RequestMapping("toMenuIndex")
	public ModelAndView toMenuIndex()
	{
		ModelAndView mv  = this.getModelAndView();
		mv.setViewName("dataEntry/dataEntry_menu");
		return mv;
	}
	
	@RequestMapping("list")
	public ModelAndView list(Page page)
	{
		PageData pd = this.getPageData();
		if(StringUtil.isEmpty(pd.getString("time")))
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);
			pd.put("time", DateUtil.date2Str(calendar.getTime(), "yyyy-MM"));
		}
		page.setPd(pd);
		List<PageData> list = new ArrayList<PageData>();
		
		try
		{
			list = RoomService.findRoomByWE(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("dataEntry/dataEntry_index");
		mv.addObject("msg", "list");
		mv.addObject("varList", list);
		mv.addObject("pd", pd);
		
		return mv;
	}
	
	@RequestMapping("waterList")
	public ModelAndView waterList(Page page)
	{
		PageData pd = this.getPageData();
		if(StringUtil.isEmpty(pd.getString("time")))
		{
			pd.put("time", DateUtil.date2Str(new Date(), "yyyy-MM"));
		}
		page.setPd(pd);
		List<PageData> list = new ArrayList<>();
		
		try
		{
			list = dataEntryService.listPage(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("dataEntry/water");
		mv.addObject("pd", pd);
		mv.addObject("msg", "waterList");
		mv.addObject("varList", list);
		return mv;
	}
	
	@RequestMapping("electricList")
	public ModelAndView electricList(Page page)
	{
		PageData pd = this.getPageData();
		if(StringUtil.isEmpty(pd.getString("time")))
		{
			pd.put("time", DateUtil.date2Str(new Date(), "yyyy-MM"));
		}
		page.setPd(pd);
		List<PageData> list = new ArrayList<>();
		
		try
		{
			list = dataEntryService.listPage(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("dataEntry/electric");
		mv.addObject("pd", pd);
		mv.addObject("msg", "electricList");
		mv.addObject("varList", list);
		return mv;
	}
	
	@RequestMapping("toIndex")
	public ModelAndView toIndex()
	{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		mv.setViewName("dataEntry/dataEntry_index");
		mv.addObject("pd", pd);
		mv.addObject("msg", "list");
		return mv;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Object save()
	{
		PageData pd = this.getPageData();
		if(StringUtil.isEmpty(pd.getString("time")))
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);
			pd.put("time", DateUtil.date2Str(calendar.getTime(), "yyyy-MM"));
		}
		
		long count = 0;
		long days = 0;
		try
		{
			dataEntryService.save(pd);
			String weId = pd.get("weId").toString();
			List<PageData> list = paymentService.findEmpByRoomId(pd);
			if(list != null)
			{
				String time = pd.getString("time");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(DateUtil.str2Date(time + "-01"));
				for(int i = 0; i < list.size(); i++)
				{
					days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					PageData pageData = list.get(i);
					String leaveTime = pageData.getString("leaveTime");
					String enterTime = pageData.getString("enterTime");
					Calendar enterCalendar = Calendar.getInstance();
					enterCalendar.setTime(DateUtil.str2Date(enterTime));
					long enterDays = (enterCalendar.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
					if(!StringUtil.isEmpty(leaveTime))
					{
						//当月退租者居住时长
						Calendar leaveCalendar = Calendar.getInstance();
						leaveCalendar.setTime(DateUtil.str2Date(leaveTime));
						long leaveDays = (leaveCalendar.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60 * 24);
						days = leaveDays;
						employeeService.deleteById(pageData);
					}
					else if(enterDays > 0)
					{
						//当月入住者居住时长
						days = days - enterDays;
					}
						
					count += days;
				}
			}
			pd.put("days", count);
			pd.put("weId", weId);
			dataEntryService.updateDaysById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return Constant.AJAX_SUCCESS;
	}
	
	@RequestMapping("goWaterEdit")
	public ModelAndView goEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = dataEntryService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		ModelAndView mv = this.getModelAndView();
		mv.setViewName("dataEntry/water_edit");
		mv.addObject("pd", pd);
		mv.addObject("msg", "waterEdit");

		return mv;
	}
	
	@RequestMapping("waterEdit")
	@ResponseBody
	public void waterEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			dataEntryService.updateById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping("goElectricEdit")
	public ModelAndView goElectricEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = dataEntryService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		ModelAndView mv = this.getModelAndView();
		mv.setViewName("dataEntry/electric_edit");
		mv.addObject("pd", pd);
		mv.addObject("msg", "electircEdit");

		return mv;
	}
	
	@RequestMapping("electircEdit")
	@ResponseBody
	public void electircEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			dataEntryService.updateById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
