package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.OrderStatus;
import rj.pojo.Orders;
import rj.pojo.PayWay;
import rj.service.OrderStatusService;

public class OrderStatusServiceImpl implements OrderStatusService {

	@Override
	public OrderStatus getOrderStatus(int statusid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OrderStatus orderstatus = new OrderStatus();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select name from orderstatus where statusid="
							+ statusid+"");
			
			if(rs.next()){

				orderstatus.setName(rs.getString("name"));
				orderstatus.setStatusid(statusid);
			}
		} catch (Exception e) {
			e.printStackTrace();

			throw new RuntimeException("error when querying Product ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

				throw new RuntimeException("error when querying", e);
			}
		}

		return orderstatus;

	}

	

}
