
package rj.dao;

import rj.pojo.OrderStatus;
import rj.pojo.Orders;

public interface OrderStatusDao {

	public OrderStatus getOrderStatusByOrderid(OrderStatus paramOrderStatus);
	
}
