 /**
 * 
 */
package com.imooc.passbook.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.passbook.constant.Constants;

/**
 * @author liforever
 * 对http 请求进行拦截处理
 * 2019年3月24日
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor{


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String token = request.getHeader(Constants.TOKEN_STRING);
		if(StringUtils.isEmpty(token)) {
			throw new Exception("Header 中缺少 " + Constants.TOKEN_STRING + "!");
		}
		if(!token.equals(Constants.TOKEN)) {
			throw new Exception("Header 中" + Constants.TOKEN_STRING+ "错误!");
		}
		AccessContext.setToken(token);
		return true;
	}
	

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		AccessContext.clearAccessKey();
	}
}
