package rj.util;

import rj.service.UserService;
import rj.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static UserService userService = new UserServiceImpl();

	public static UserService getUserService() {
		return userService;
	}

}
