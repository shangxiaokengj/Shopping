package rj.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rj.pojo.ContactInfo;
import rj.pojo.Orders;
import rj.service.ContactInfoService;
import rj.service.OrderLineService;
import rj.service.OrderService;

public class ContactInfoServiceImpl implements ContactInfoService {

	public List getContactInfoList() {
		return null;
	}

	public ContactInfo getContactInfo(String userid) {

		Connection conn = null;

		Statement stmt = null;
		ResultSet rs = null;
		ContactInfo contactinfo = new ContactInfo();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gwap", "root", "");
			stmt = conn.createStatement();
			String sql = "select * from contactinfo where userid ='" + userid
					+ "' ";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			System.out.println(sql);

			if (rs.next()) {
				
				System.out.println(rs.getString("cellphone"));
				
				contactinfo.setCellphone(rs.getString("cellphone"));
				
				System.out.println(contactinfo.getCellphone());
				
				contactinfo.setCity(rs.getString("city"));
				contactinfo.setContactid(rs.getInt("contactid"));
				contactinfo.setCountry(rs.getString("country"));
				contactinfo.setEmail(rs.getString("email"));
				contactinfo.setHomephone(rs.getString("homephone"));
				contactinfo.setOfficephone(rs.getString("officephone"));
				contactinfo.setProvince(rs.getString("province"));
				contactinfo.setStreet1(rs.getString("street1"));
				contactinfo.setStreet2(rs.getString("street2"));
				contactinfo.setUserid(rs.getString("userid"));
				contactinfo.setZip(rs.getString("zip"));

			} else {
				System.out.println("null");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("error when querying contactinfo ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

				throw new RuntimeException("error when querying contactinfo ", e);
			}
		}
		return contactinfo;
		
	}

}
