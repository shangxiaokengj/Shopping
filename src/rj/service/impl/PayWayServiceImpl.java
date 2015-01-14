package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import rj.pojo.PayWay;
import rj.pojo.Product;
import rj.service.PayWayService;

public class PayWayServiceImpl implements PayWayService {

	@Override
	public PayWay getPayWay(int paywayid) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PayWay payway = new PayWay();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");

			stmt = conn.createStatement();

			rs = stmt
					.executeQuery("select paystyle from payway where paywayid="
							+ paywayid + "");

			if (rs.next()) {
				payway.setPaystyle(rs.getString("paystyle"));
				payway.setPaywayid(paywayid);
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

		return payway;

	}

}
