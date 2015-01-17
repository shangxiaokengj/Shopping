package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rj.pojo.Category;
import rj.pojo.Product;
import rj.service.CategoryService;
import rj.util.DaoFactory;

public class CategoryServerImpl implements CategoryService {

	@Override
	public Category getCategory(Category paramCategory) {
		return DaoFactory.getCategoryDaoDao().getCategory(paramCategory);
	}

}
