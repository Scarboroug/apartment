package com.hbxy.action;

import com.hbxy.bean.Page;
import com.hbxy.service.RoomService;
import com.hbxy.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("room")
public class RoomAction extends BaseAction
{
	@Autowired
	private RoomService roomservice;

    /**
     * 房间管理
     * @return
     */
	@RequestMapping("toMenuIndex")
	public String toMenuIndex()
	{
		return "room/room_menu";
	}

	/**
	 * 房间管理列表
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(Page page)
	{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		page.setPd(pd);
		
		List<PageData> list = null;
		try
		{
			list = roomservice.findAlllistPage(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		mv.addObject("pd", pd);
		mv.addObject("msg", "list");
		mv.addObject("varList", list);
		mv.setViewName("room/room_index");
		return mv;
	}

	/**
	 * 新增房间
	 * @return
	 */
	@RequestMapping("goSave")
	public ModelAndView goSave()
	{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("room/room_edit");
		mv.addObject("msg", "save");
		return mv;
	}

	/**
	 * 持久化
	 * @return
	 */
	@RequestMapping("save")
	public ModelAndView save()
	{
		PageData pd = this.getPageData();
		pd.put("total", 0);
		pd.put("gender", 3);
		
		try
		{
			roomservice.insertRoom(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "list");
		mv.setViewName("room/room_index");
		return mv;
	}
}
