package rj.util;

import rj.dao.UserDao;
import rj.dao.impl.UserDaoImpl;

public class DaoFactory {

	private static UserDao userDao = new UserDaoImpl();

	public static UserDao getUserDao() {
		return userDao;
	}

}
