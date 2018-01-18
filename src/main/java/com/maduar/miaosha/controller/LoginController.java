package com.maduar.miaosha.controller;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.druid.util.StringUtils;
import com.maduar.miaosha.result.CodeMsg;
import com.maduar.miaosha.result.Result;
import com.maduar.miaosha.service.MiaoshsaUserSerice;
import com.maduar.miaosha.service.UserService;
import com.maduar.miaosha.util.ValidatorUtil;
import com.maduar.miaosha.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController {

  private static Logger log = LoggerFactory.getLogger(LoginController.class);

  @RequestMapping("/to_login")
  public String to_login() {
    return "login";
  }


  @Autowired
  MiaoshsaUserSerice miaoshsaUserSerice;

  @RequestMapping("/do_login")
  @ResponseBody
  public Result<Boolean> do_login(HttpServletResponse response, @Valid LoginVo vo) {
    miaoshsaUserSerice.login(response, vo);
    return Result.success(true);
  }
}
