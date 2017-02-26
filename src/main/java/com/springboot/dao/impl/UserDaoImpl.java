package com.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springboot.dao.UserDao;
import com.springboot.entity.User;

//@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		jdbc.update("insert into tbuser values(?,?,?)", user.getId(), user.getName(), user.getAge());
	}

//	@Override
//	public List<User> getAllUser() {
//		// TODO Auto-generated method stub
//		return jdbc.query("select * from tbuser", User.class);
//	}

}
