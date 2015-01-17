package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.Product;
import rj.pojo.User;
import rj.service.UserService;
import rj.util.DaoFactory;

public class UserServiceImpl implements UserService {

	@Override
	public List getUserList() {
		return DaoFactory.getUserDao().getUserList();
	}

	@Override
	public User getUser(User paramUser) {
		return DaoFactory.getUserDao().getUser(paramUser);
	}

	@Override
	public User getUserByUserid(String userid) {
		return DaoFactory.getUserDao().getUserByUserid(userid);
	}
	

}
