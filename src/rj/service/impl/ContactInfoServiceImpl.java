package rj.service.impl;

import java.util.List;

import rj.pojo.ContactInfo;
import rj.pojo.User;
import rj.service.ContactInfoService;
import rj.util.DaoFactory;

public class ContactInfoServiceImpl implements ContactInfoService {

	public List getContactInfoList() {
		return null;
	}

	public ContactInfo getContactInfo(User paramUser) {

		return DaoFactory.getContactInfoDao().getContactInfo(paramUser);
	}

}
