package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.Product;
import rj.service.ProductService;
import rj.util.DaoFactory;

public class ProductServiceImpl implements ProductService {

	@Override
	public List getProductList() {
		return DaoFactory.getProductDao().getProductList();
	}

	@Override
	public Product getProduct(Product paramProduct) {
		return DaoFactory.getProductDao().getProduct(paramProduct);
	}

	
	
}
