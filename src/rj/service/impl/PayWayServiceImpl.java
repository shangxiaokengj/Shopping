package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import rj.pojo.PayWay;
import rj.pojo.Product;
import rj.service.PayWayService;
import rj.util.DaoFactory;

public class PayWayServiceImpl implements PayWayService {

	@Override
	public PayWay getPayWay(PayWay paramPayway) {

		return DaoFactory.getPayWay().getPayWay(paramPayway);
	}

}
