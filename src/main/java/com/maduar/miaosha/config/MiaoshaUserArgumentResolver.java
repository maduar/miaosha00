package com.maduar.miaosha.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.alibaba.druid.util.StringUtils;
import com.maduar.miaosha.domain.MiaoshaUser;
import com.maduar.miaosha.service.MiaoshsaUserSerice;
import javax.servlet.http.Cookie;

@Service
public class MiaoshaUserArgumentResolver implements HandlerMethodArgumentResolver{
  
  @Autowired
  MiaoshsaUserSerice miaoshsaUserSerice;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    // TODO Auto-generated method stub
    Class<?> clazz = parameter.getParameterType();
    return clazz == MiaoshaUser.class;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    // TODO Auto-generated method stub
    HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
    HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
    
    String paramToken = request.getParameter(MiaoshsaUserSerice.COOKIE_NAME_TOKEN);
    String cookieToken = getCookieName(request, MiaoshsaUserSerice.COOKIE_NAME_TOKEN);
    
    if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
      return null;
    }
    
    String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
    return miaoshsaUserSerice.getByToken(response, token);
  }
  
  public String getCookieName(HttpServletRequest request, String cookieName) {
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie: cookies) {
      if (cookie.getName().equals(cookieName)) {
        return cookie.getValue();
      }
    }
    return null;
  }

}
