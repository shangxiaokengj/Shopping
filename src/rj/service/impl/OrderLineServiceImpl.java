package rj.service.impl;

import java.util.List;

import rj.service.OrderLineService;
import rj.util.DaoFactory;

public class OrderLineServiceImpl implements OrderLineService {

	@Override
	public List getOrderLineList(String orderid) {
		return DaoFactory.getOrderLineDao().getOrderLineList(orderid);
	}

}
