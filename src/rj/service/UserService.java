package rj.service;

import java.util.List;

import rj.pojo.User;

public interface UserService {
	
	public List getUserList();

	public User getUser(User paramUser);
	
	public User getUserByUserid(String userid);
}
