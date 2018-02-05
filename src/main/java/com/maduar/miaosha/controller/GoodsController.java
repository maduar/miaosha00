package com.maduar.miaosha.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.maduar.miaosha.domain.Goods;
import com.maduar.miaosha.domain.MiaoshaGoods;
import com.maduar.miaosha.domain.MiaoshaUser;
import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.service.GoodsService;
import com.maduar.miaosha.service.MiaoshsaUserSerice;
import com.maduar.miaosha.vo.GoodsVo;

@Controller
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  MiaoshsaUserSerice miaoshsaUserSerice;

  @Autowired
  GoodsService goodsService;

  @RequestMapping("/to_list")
  public String to_list(Model model, MiaoshaUser miaoshaUser) {
    model.addAttribute("user", miaoshaUser);
    List<GoodsVo> goodsList = goodsService.listGoodsVo();
    model.addAttribute("goodsList", goodsList);
    return "goods_list";
  }

  @RequestMapping("/to_detail/{goodsId}")
  public String to_detail(Model model, MiaoshaUser miaoshaUser,
      @PathVariable("goodsId") Long goodsId) {
    // snowflake
    model.addAttribute("user", miaoshaUser);
    GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
    Long startAt = goodsVo.getStartDate().getTime();
    Long endAt = goodsVo.getEndDate().getTime();
    Long now = System.currentTimeMillis();
    
    int miaoshaState = 0;
    int remainSeconds = 0;
    
    if (now < startAt) {// miaosha not start
      miaoshaState = 0;
      remainSeconds = (int) ((startAt - now) / 1000);
      
    } else if (now > endAt) { // over time
      miaoshaState = 2;
      remainSeconds = -1;
    } else {
      miaoshaState = 1;
      remainSeconds = 0;
    }
    model.addAttribute("miaoshaState", miaoshaState);
    model.addAttribute("miaoshaState", miaoshaState);
    model.addAttribute("goods", goodsVo);
    return "goods_detail";
  }
}
