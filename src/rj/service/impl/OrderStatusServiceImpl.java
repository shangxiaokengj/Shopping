package rj.service.impl;

import rj.pojo.OrderStatus;
import rj.service.OrderStatusService;
import rj.util.DaoFactory;

public class OrderStatusServiceImpl implements OrderStatusService {

	@Override
	public OrderStatus getOrderStatusByOrderid(OrderStatus paramOrderStatus) {
		
		return DaoFactory.getOrderStatus().getOrderStatusByOrderid(paramOrderStatus);
	}

}
