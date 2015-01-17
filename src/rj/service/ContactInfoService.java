package rj.service;

import java.util.List;

import rj.pojo.ContactInfo;
import rj.pojo.User;


public interface ContactInfoService {

	public List getContactInfoList();
	
	public ContactInfo getContactInfo(User paramUser);
}
