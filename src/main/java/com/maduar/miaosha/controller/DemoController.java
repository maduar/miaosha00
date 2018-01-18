package com.maduar.miaosha.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.redis.RedisConfig;
import com.maduar.miaosha.redis.RedisPoolFactory;
import com.maduar.miaosha.redis.RedisService;
import com.maduar.miaosha.redis.UserPrefix;
import com.maduar.miaosha.result.CodeMsg;
import com.maduar.miaosha.result.Result;
import com.maduar.miaosha.service.UserService;

@Controller
@RequestMapping("/demo")
public class DemoController {

  @RequestMapping("/hello")
  @ResponseBody
  public Result<String> home() {
    return Result.success("HENHAO");
  }

  @RequestMapping("/helloError")
  @ResponseBody
  public Result<CodeMsg> helloError() {
    return Result.error(CodeMsg.SERVER_ERROR);
  }

  @RequestMapping("/thymeleaf")
  public String thymeleaf(Model model) {
    model.addAttribute("name", "nishishui");
    return "hello";
  }

  @Autowired
  UserService userService;


  @RequestMapping("/db/get")
  @ResponseBody
  public Result<User> dbGet() {
    User user = userService.getById(1);
    return Result.success(user);
  }


  @Autowired
  RedisConfig redisConfig;

  @Autowired
  RedisService redisService;

  @RequestMapping(value = "/redis/get/{key}", method = RequestMethod.GET)
  @ResponseBody
  public Result<User> redisGet(@PathVariable("key") int key) {
    User user = redisService.get(UserPrefix.getById, "" + key, User.class);
    return Result.success(user);
  }

  @RequestMapping(value = "/redis/set/{id}/{name}", method = RequestMethod.GET)
  @ResponseBody
  public Result<Boolean> redisSet(@PathVariable("id") int id, @PathVariable("name") String name) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    redisService.set(UserPrefix.getById, "" + id, JSON.toJSONString(user));
    return Result.success(true);
  }
}
