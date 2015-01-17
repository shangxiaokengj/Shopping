package rj.dao;

import java.util.List;

import rj.pojo.User;

public interface UserDao {

	public List getUserList();

	public User getUser(User paramUser);

	public User getUserByUserid(String userid);
}
