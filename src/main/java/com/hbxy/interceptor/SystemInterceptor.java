package com.hbxy.interceptor;

import com.hbxy.common.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SystemInterceptor extends HandlerInterceptorAdapter
{
	private static Logger log = LogManager.getLogger(SystemInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		log.debug("进入拦截器");
		log.info("进入拦截器");
		String uri = request.getRequestURI();
		log.debug("Pre-handle url=" + uri);

		if (uri.endsWith(request.getContextPath() + "/login/toLogin.do")
				|| uri.endsWith(request.getContextPath() + "/login/doLogin.do"))
		{
			log.debug(uri + " 不进行拦截");
			log.info(uri + " 不进行拦截");

		} else
		{
			// session失效，到登录页面
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute(Constant.SESSION_USER_NAME_STRING);

			if (userId == null || userId.equals(""))
			{

				// AJAX方法访问
				if (handler instanceof HandlerMethod)
				{
					// 有权限控制的就要检查
					if (((HandlerMethod) handler).getMethod().isAnnotationPresent(ResponseBody.class))
					{
						response.sendRedirect(request.getContextPath() + "/ajaxSessionOut.txt");
						System.out.println(request.getContextPath() + "/ajaxSessionOut.txt");
					} else
					{
						// 非ajax请求,页面跳转请求
						response.sendRedirect(request.getContextPath());
					}
				} else
				{
					// 非ajax请求,页面跳转请求
					PrintWriter out = response.getWriter();
					out.write("<script>window.top.location.href='"+request.getContextPath() + Constant.LOGIN+"'</script>"); 
				}
				log.debug("SESSION 失效 返回登陆页面");
				return false;
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception
	{
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
