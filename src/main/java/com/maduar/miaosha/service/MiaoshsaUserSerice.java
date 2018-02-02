package com.maduar.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.druid.util.StringUtils;
import com.maduar.miaosha.controller.LoginController;
import com.maduar.miaosha.dao.MiaoshaUserDao;
import com.maduar.miaosha.domain.MiaoshaUser;
import com.maduar.miaosha.exception.GlobalException;
import com.maduar.miaosha.redis.MiaoshaUserKey;
import com.maduar.miaosha.redis.RedisService;
import com.maduar.miaosha.result.CodeMsg;
import com.maduar.miaosha.util.Md5Util;
import com.maduar.miaosha.util.UUIDUtil;
import com.maduar.miaosha.vo.LoginVo;
import com.mysql.jdbc.log.Log;

@Service
public class MiaoshsaUserSerice {

  private static Logger log = LoggerFactory.getLogger(MiaoshsaUserSerice.class);
  public static final String COOKIE_NAME_TOKEN = "token";

  @Autowired
  MiaoshaUserDao miaoshaUserDao;

  @Autowired
  RedisService redisService;

  public MiaoshaUser getById(Long id) {
    return miaoshaUserDao.getById(id);
  }

  public MiaoshaUser getByToken(HttpServletResponse response, String token) {
    if (StringUtils.isEmpty(token)) {
      return null;
    }
    MiaoshaUser miaoshaUser = redisService.get(MiaoshaUserKey.tocken, token, MiaoshaUser.class);
    if (miaoshaUser != null) {
      addCookie(response, token, miaoshaUser);
    }

    return miaoshaUser;
  }

  public boolean login(HttpServletResponse response, LoginVo vo) {
    // TODO Auto-generated method stub
    if (vo == null) {
      throw new GlobalException(CodeMsg.SERVER_ERROR);
    }

    String mobile = vo.getMobile();
    String formPassword = vo.getPassword();
    MiaoshaUser miaoshaUser = getById(Long.parseLong(mobile));
    if (miaoshaUser == null) {
      throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
    }

    String dbPassword = miaoshaUser.getPassword();
    String dbSalt = miaoshaUser.getSalt();
    String calcPassword = Md5Util.formPassToDbPass(formPassword, dbSalt);

    if (!dbPassword.equals(calcPassword)) {
      throw new GlobalException(CodeMsg.PASSWORD_ERROR);
    }

    String token = UUIDUtil.uuid();
    addCookie(response, token, miaoshaUser);
    return true;
  }

  public void addCookie(HttpServletResponse response, String token, MiaoshaUser miaoshaUser) {
    
    redisService.set(MiaoshaUserKey.tocken, token, miaoshaUser);
    Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
    cookie.setMaxAge(MiaoshaUserKey.tocken.expireSeconds());
    cookie.setPath("/");
    response.addCookie(cookie);
  }
}
