package rj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.dao.OrdersDao;
import rj.pojo.Orders;
import rj.util.ConnectionFactory;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public List getOrderList() {

		List orderlist = new ArrayList();

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();

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
		} catch (Exception e) {
			throw new RuntimeException("error when querying orders ", e);
		} finally {
			try {
				if(rs != null){
					rs.close();	
				}
				if(stmt!= null){
					
					stmt.close();
				}
				if(conn != null){
					
					conn.close();
				}
			} catch (Exception e) {
				throw new RuntimeException("error when querying orders ", e);
			}
		}
		return orderlist;

	}

	@Override
	public Orders getOrder(Orders paramOrder) {
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		Orders orders = new Orders();
		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from orders where orderid ="
					+ paramOrder.getOrderid() + "";

			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				orders.setOrderid(rs.getInt("orderid"));
				orders.setName(rs.getString("name"));
				orders.setCost(rs.getDouble("cost"));
				orders.setPaywayid(rs.getInt("paywayid"));
				orders.setStatusid(rs.getInt("statusid"));
				orders.setUserid(rs.getString("userid"));

			} else {
				System.out.println("orders does not exist");
			}
		} catch (Exception e) {
			throw new RuntimeException("error when querying orders ", e);
		} finally {
			try {
				if(rs != null){
					rs.close();	
				}
				if(stmt!= null){
					
					stmt.close();
				}
				if(conn != null){
					
					conn.close();
				}
			} catch (Exception e) {
				throw new RuntimeException("error when querying orders ", e);
			}
		}

		return orders;

	}

}
