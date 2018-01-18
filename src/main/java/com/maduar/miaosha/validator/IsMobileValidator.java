package com.maduar.miaosha.validator;

import com.alibaba.druid.util.StringUtils;
import com.maduar.miaosha.util.ValidatorUtil;
import com.maduar.miaosha.validator.IsMobile;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.codehaus.groovy.util.StringUtil;


// 一个参数是注解，一个是注解的类型
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

  private boolean required = false;

  @Override
  public void initialize(IsMobile constraintAnnotation) {
    required = constraintAnnotation.required();

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // TODO Auto-generated method stub
    if (required) {
      return ValidatorUtil.isMobile(value);
    } else {
      if (StringUtils.isEmpty(value)) {
        return true;
      } else {
        return ValidatorUtil.isMobile(value);
      }
    }
  }

}
