package com.hbxy.action;

import com.hbxy.bean.LoginBean;
import com.hbxy.common.Constant;
import com.hbxy.service.LoginService;
import com.ndktools.javamd5.Mademd5;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginAction extends BaseAction
{
	Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("toLogin")
	public String toLogin()
	{
		System.out.println("进入注册页面");
		return "login/login";
	}
	
	@RequestMapping("toIndex")
	public String toIndex()
	{
		return "index/index";
	}

	/**
	 * 登录
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest request, String userName, String password)
	{

		LoginBean loginBean = loginService.findByLoginName(userName);
		if(loginBean != null)
		{
			if(loginBean.getPassword().equals(new Mademd5().toMd5(password)))
			{
				HttpSession session = request.getSession();
				session.setAttribute(Constant.SESSION_USERID_INTEGER, loginBean.getLoginId());
				session.setAttribute(Constant.SESSION_USER_NAME_STRING, loginBean.getLoginName());
				session.setAttribute(Constant.SESSION_USER_ROLE_INTEGER, loginBean.getRole());
				return Constant.AJAX_SUCCESS;
			}
		}
		
		return Constant.AJAX_FAIL;
	}

	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout()
	{
		try
		{
			HttpSession session = this.getRequest().getSession();
			session.removeAttribute(Constant.SESSION_USER_NAME_STRING);
			session.removeAttribute(Constant.SESSION_USER_ROLE_INTEGER);
			session.removeAttribute(Constant.SESSION_USERID_INTEGER);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv= this.getModelAndView();
		mv.setViewName("login/login");
		return mv;
	}
}
