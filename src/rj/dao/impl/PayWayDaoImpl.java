package rj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import rj.dao.PayWayDao;
import rj.pojo.PayWay;
import rj.util.ConnectionFactory;

public class PayWayDaoImpl implements PayWayDao {

	@Override
	public PayWay getPayWay(PayWay paramPayway) {
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		PayWay payway = new PayWay();
		try {
			conn = ConnectionFactory.getConnection();
			
			stmt = conn.createStatement();

			rs = stmt
					.executeQuery("select paystyle from payway where paywayid="
							+ paramPayway.getPaywayid() + "");

			if (rs.next()) {
				payway.setPaystyle(rs.getString("paystyle"));
				payway.setPaywayid(paramPayway.getPaywayid());
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
