package rj.dao;

import java.util.List;

import rj.pojo.Orders;

public interface OrdersDao {

	public List getOrderList();

	public Orders getOrder(Orders paramOrder);

	
}
