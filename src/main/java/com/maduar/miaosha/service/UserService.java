package com.maduar.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maduar.miaosha.dao.UserDao;
import com.maduar.miaosha.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User getById(int id) {
		return userDao.getById(id);
	}
}



