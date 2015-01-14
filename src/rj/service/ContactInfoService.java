package rj.service;

import java.util.List;

import rj.pojo.ContactInfo;


public interface ContactInfoService {

	public List getContactInfoList();
	
	public ContactInfo getContactInfo(String userid);
}
