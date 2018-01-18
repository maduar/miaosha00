package com.maduar.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.maduar.miaosha.domain.MiaoshaUser;

@Mapper
public interface MiaoshaUserDao {

  @Select("SELECT * FROM miaosha_user WHERE id = #{id} ;")
  public MiaoshaUser getById(@Param("id")Long id);
}
