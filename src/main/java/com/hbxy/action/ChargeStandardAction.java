package com.hbxy.action;

import com.hbxy.bean.Page;
import com.hbxy.service.ChargeStandardService;
import com.hbxy.service.RoomTypeService;
import com.hbxy.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("chargeStandard")
public class ChargeStandardAction extends BaseAction
{
	@Resource(name = "chargeStandardService")
	ChargeStandardService chargeStandardService;
	
	@Resource(name = "roomTypeService")
	RoomTypeService roomTypeService;
	
	@RequestMapping("toMenuIndex")
	public String toMenuIndex()
	{
		return "chargeStandard/chargeStandard_menu";
	}
	
	@RequestMapping("toIndex")
	public String toIndex()
	{
		return "chargeStandard/index";
	}
	
	@RequestMapping("list")
	public ModelAndView list(Page page)
	{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		
		List<PageData> list = null;
		try
		{
			list = chargeStandardService.findAll(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		mv.addObject("pd", pd);
		mv.addObject("msg", "list");
		mv.addObject("varList", list);
		mv.setViewName("chargeStandard/index");
		return mv;
	}
	
	@RequestMapping("goEdit")
	public ModelAndView goEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = chargeStandardService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("msg", "edit");
		mv.setViewName("chargeStandard/chargeStandard_edit");
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit()
	{
		PageData pd = this.getPageData();
		
		try
		{
			chargeStandardService.updateById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "list");
		mv.setViewName("chargeStandard/index");
		return mv;
	}
	
	@RequestMapping("roomTypeList")
	public ModelAndView roomTypeList(Page page)
	{
		List<PageData> list = null;
		
		try
		{
			list = roomTypeService.findAlllistPage(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("chargeStandard/cs_roomType");
		mv.addObject("msg", "roomTypeList");
		mv.addObject("varList", list);
		return mv;
	}
	
	@RequestMapping("goRoomTypeEdit")
	public ModelAndView goRoomTypeEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = roomTypeService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("msg", "roomTypeEdit");
		mv.setViewName("chargeStandard/roomType_edit");
		return mv;
	}
	
	@RequestMapping("roomTypeEdit")
	public ModelAndView roomTypeEdit()
	{
		PageData pd = this.getPageData();
		
		try
		{
			roomTypeService.updateRoomType(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "roomTypeList");
		mv.setViewName("chargeStandard/cs_roomType");
		return mv;
	}
}
