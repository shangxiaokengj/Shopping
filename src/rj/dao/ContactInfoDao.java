
package rj.dao;

import java.util.List;

import rj.pojo.ContactInfo;
import rj.pojo.User;

public interface ContactInfoDao {

	public List getContactInfoList();

	public ContactInfo getContactInfo(User paramUser );
}
