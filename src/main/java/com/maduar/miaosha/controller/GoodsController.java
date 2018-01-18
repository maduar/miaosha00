package com.maduar.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.druid.util.StringUtils;
import com.maduar.miaosha.domain.MiaoshaUser;
import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.service.MiaoshsaUserSerice;

@Controller
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  MiaoshsaUserSerice miaoshsaUserSerice;
  
  @RequestMapping("/to_list")
  public String to_list(Model model, MiaoshaUser miaoshaUser) {

    model.addAttribute("user", miaoshaUser);
    return "goods_list";
  }
}
