package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.Orders;
import rj.service.OrderService;
import rj.util.DaoFactory;

public class OrderServiceImpl implements OrderService {

	@Override
	public List getOrderList() {
		return DaoFactory.getOrders().getOrderList();
	}

	@Override
	public Orders getOrder(Orders paramOrder) {

		return DaoFactory.getOrders().getOrder(paramOrder);
	}

}
