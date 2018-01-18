package com.maduar.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.maduar.miaosha.domain.User;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM user WHERE id = #{id}")
	public User getById(@Param("id") int id);
}
