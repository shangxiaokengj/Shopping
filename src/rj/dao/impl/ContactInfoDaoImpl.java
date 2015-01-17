package rj.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import rj.dao.ContactInfoDao;
import rj.pojo.ContactInfo;
import rj.pojo.User;
import rj.util.ConnectionFactory;

public class ContactInfoDaoImpl implements ContactInfoDao {

	@Override
	public List getContactInfoList() {
		return null;
	}

	@Override
	public ContactInfo getContactInfo(User paramUser) {
		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		ContactInfo contactinfo = new ContactInfo();
		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from contactinfo where userid ='"
					+ paramUser.getUserid() + "' ";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {

				contactinfo.setCellphone(rs.getString("cellphone"));
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
		} catch (Exception e) {
			throw new RuntimeException("error when querying contactinfo ", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException("error when querying contactinfo ",
						e);
			}
		}
		return contactinfo;
	}

}
