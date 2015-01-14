package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.OrderLine;
import rj.pojo.Orders;
import rj.service.OrderLineService;

public class OrderLineServiceImpl implements OrderLineService {

	@Override
	public List getOrderLineList(String orderid) {
		List orderLinelist = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from orderline where orderid ='"
					+ orderid + "'");

			while (rs.next()) {
				OrderLine orderline = new OrderLine();
				orderline.setLineid(rs.getInt("lineid"));
				orderline.setOrderid(rs.getInt("orderid"));
				orderline.setProductid(rs.getInt("productid"));
				orderline.setAmount(rs.getDouble("amount"));
				orderLinelist.add(orderline);
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
		return orderLinelist;
	}

}
