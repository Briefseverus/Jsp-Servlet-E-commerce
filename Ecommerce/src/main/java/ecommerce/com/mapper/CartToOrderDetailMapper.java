package ecommerce.com.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import ecommerce.com.daos.OrderDetailDao;
import ecommerce.com.models.Cart;
import ecommerce.com.models.CartItem;
import ecommerce.com.models.Order;
import ecommerce.com.models.OrderDetail;

public class CartToOrderDetailMapper {
	public static List<OrderDetail> mapToOrderDetail(Cart cart, int orderId) {
		List<OrderDetail> orders = new ArrayList<>();
		List<CartItem> cartItems = cart.getItems();
		for (CartItem cartItem : cartItems) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder_id(orderId);
			orderDetail.setProduct_id(cartItem.getProductId());
			orderDetail.setQuantity(cartItem.getQuantity());
			orders.add(orderDetail);
		}
		return orders;
	}
}
