package com.maduar.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.alibaba.druid.util.StringUtils;

public class ValidatorUtil {

  private static final Pattern mobile_patter = Pattern.compile("1\\d{10}");

  public static Boolean isMobile(String mobile) {

    if (StringUtils.isEmpty(mobile)) {
      return false;
    }

    Matcher m = mobile_patter.matcher(mobile);
    return m.matches();
  }
  
  public static void main(String[] args) {
    String mobile = "22222222222";
    System.out.println(isMobile(mobile));
  }

}
