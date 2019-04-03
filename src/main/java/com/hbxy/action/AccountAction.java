package com.hbxy.action;

import com.hbxy.bean.Page;
import com.hbxy.common.Constant;
import com.hbxy.service.AccountService;
import com.hbxy.util.PageData;
import com.ndktools.javamd5.Mademd5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountAction extends BaseAction
{
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("toMenuIndex")
	public String toMenuIndex()
	{
		return "account/account_menu";
	}
	
	@RequestMapping("toIndex")
	public String toIndex()
	{
		return "account/account_index";
	}
	
	@RequestMapping("list")
	public ModelAndView list(Page page)
	{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		pd.put("role", 0);
		page.setPd(pd);
		
		List<PageData> list = null;
		try
		{
			list = accountService.findlistPage(page);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		mv.addObject("pd", pd);
		mv.addObject("msg", "list");
		mv.addObject("varList", list);
		mv.setViewName("account/account_index");
		return mv;
	}
	
	@RequestMapping("goSave")
	public ModelAndView goSave()
	{
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "save");
		mv.setViewName("account/account_add");
		return mv;
	}
	
	@RequestMapping("save")
	public ModelAndView save()
	{
		PageData pd = this.getPageData();
		String password = pd.getString("password");
		password = new Mademd5().toMd5(password);
		pd.put("password", password);
		
		try
		{
			accountService.save(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "save");
		mv.setViewName("account/account_add");
		return mv;
	}
	
	@RequestMapping("goEdit")
	public ModelAndView goEdit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd = accountService.findById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ModelAndView mv = this.getModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("msg", "edit");
		mv.setViewName("account/account_edit");
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit()
	{
		PageData pd = this.getPageData();
		try
		{
			pd.put("password", new Mademd5().toMd5(pd.getString("password")));
			accountService.updateById(pd);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv = this.getModelAndView();
		mv.addObject("msg", "save");
		mv.setViewName("account/account_add");
		return mv;
	}
	
	@RequestMapping("removeAll")
	@ResponseBody
	public String removeAll()
	{
		PageData pd = this.getPageData();
		
		try
		{
			String id = pd.getString("ids");
			if(null != id && !"".equals(id)){
				String ids[] = id.split(",");
				int[] loginIds = new int[ids.length];
				for(int i = 0; i < ids.length; i++)
				{
					loginIds[i] = Integer.parseInt(ids[i]);
				}
				accountService.removeAll(loginIds);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			return Constant.AJAX_FAIL;
		}
		
		return Constant.AJAX_SUCCESS;
	}
	
	@RequestMapping("checkUser")
	@ResponseBody
	public String checkUser()
	{
		PageData pd = this.getPageData();
		String loginName = pd.getString("loginName");
		try
		{
			List<PageData> list = accountService.findAllLogin(pd);
			for(int i = 0; i < list.size(); i++)
			{
				pd = list.get(i);
				if(pd.getString("loginName").equals(loginName))
				{
					return Constant.AJAX_FAIL;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return Constant.AJAX_SUCCESS;
	}
}
