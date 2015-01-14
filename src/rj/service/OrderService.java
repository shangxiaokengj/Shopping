package rj.service;

import java.util.List;

import rj.order.Order;
import rj.pojo.Orders;


public interface OrderService {

	public List getOrderList();
	
	public Orders getOrder(int orderid);
}
