package rj.util;

import rj.dao.CategoryDao;
import rj.dao.ContactInfoDao;
import rj.dao.OrderLineDao;
import rj.dao.OrderStatusDao;
import rj.dao.OrdersDao;
import rj.dao.PayWayDao;
import rj.dao.ProductDao;
import rj.dao.UserDao;
import rj.dao.impl.CategoryDaoImpl;
import rj.dao.impl.ContactInfoDaoImpl;
import rj.dao.impl.OrderLineDaoImpl;
import rj.dao.impl.OrderStatusDaoImpl;
import rj.dao.impl.OrdersDaoImpl;
import rj.dao.impl.PayWayDaoImpl;
import rj.dao.impl.ProductDaoImpl;
import rj.dao.impl.UserDaoImpl;

public class DaoFactory {

	private static UserDao userDao = new UserDaoImpl();
	private static OrderStatusDao orderStatusDao = new OrderStatusDaoImpl();
	private static PayWayDao payWayDao = new PayWayDaoImpl();
	private static OrdersDao ordersDao = new OrdersDaoImpl();
	private static OrderLineDao orderLineDao = new OrderLineDaoImpl();
	private static CategoryDao categoryDao = new CategoryDaoImpl();
	private static ProductDao productDao = new ProductDaoImpl();
	private static ContactInfoDao contactInfoDao = new ContactInfoDaoImpl();

	public static ContactInfoDao getContactInfoDao() {
		return contactInfoDao;
	}

	public static ProductDao getProductDao() {
		return productDao;
	}

	public static CategoryDao getCategoryDaoDao() {
		return categoryDao;
	}

	public static OrderLineDao getOrderLineDao() {
		return orderLineDao;
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	public static OrderStatusDao getOrderStatus() {
		return orderStatusDao;
	}

	public static PayWayDao getPayWay() {
		return payWayDao;
	}

	public static OrdersDao getOrders() {
		return ordersDao;
	}

}
