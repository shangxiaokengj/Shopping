package rj.service;

import java.util.List;

import rj.pojo.Orders;
import rj.web.OrderServlet;


public interface OrderService {

	public List getOrderList();
	
	public Orders getOrder(Orders paramOrder);
}
