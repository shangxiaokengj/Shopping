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

public class OrderServiceImpl implements OrderService {

	@Override
	public List getOrderList() {
		List orderlist = new ArrayList();
		Connection conn = null;

		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from orders");

			while (rs.next()) {
				int i = Integer.parseInt(rs.getString("orderid"));
				float f = Float.parseFloat(rs.getString("cost"));
				Orders order = new Orders();
				order.setOrderid(i);
				order.setName(rs.getString("name"));
				order.setCost(f);
				order.setPaywayid(rs.getInt("paywayid"));
				order.setStatusid(rs.getInt("statusid"));
				order.setUserid(rs.getString("userid"));
				orderlist.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orders ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

				throw new RuntimeException("error when querying orders ", e);
			}
		}
		return orderlist;
	}

	@Override
	public Orders getOrder(int orderid) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Orders orders = new Orders();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			String sql = "select * from orders where orderid =" + orderid
					+ "";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println(rs.getInt("orderid"));
				
				orders.setOrderid(rs.getInt("orderid"));
				orders.setName(rs.getString("name"));
				orders.setCost(rs.getDouble("cost"));
				orders.setPaywayid(rs.getInt("paywayid"));
				orders.setStatusid(rs.getInt("statusid"));
				orders.setUserid(rs.getString("userid"));
				
			}else{
				System.out.println("orders does not exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying orders ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

				throw new RuntimeException("error when querying orders ", e);
			}
		}
		
		return orders;
	}

}
