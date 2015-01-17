package rj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import rj.dao.OrderStatusDao;
import rj.pojo.OrderStatus;
import rj.pojo.Orders;
import rj.util.ConnectionFactory;

public class OrderStatusDaoImpl implements OrderStatusDao {

	@Override
	public OrderStatus getOrderStatusByOrderid(OrderStatus paramOrderStatus) {
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		OrderStatus orderstatus = new OrderStatus();
		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select name from orderstatus where statusid="
							+ paramOrderStatus.getStatusid() + "");

			if (rs.next()) {

				orderstatus.setName(rs.getString("name"));
				orderstatus.setStatusid(paramOrderStatus.getStatusid());
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
