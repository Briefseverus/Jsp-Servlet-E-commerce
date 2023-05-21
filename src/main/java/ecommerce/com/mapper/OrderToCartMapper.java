package ecommerce.com.mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ecommerce.com.daos.ProductDao;
import ecommerce.com.models.Cart;
import ecommerce.com.models.CartItem;
import ecommerce.com.models.Order;
import ecommerce.com.models.OrderDetail;
import ecommerce.com.models.Product;

public class OrderToCartMapper {

	public static CartItem mapToCartItem(OrderDetail orderDetail, ProductDao productDao) {
	    CartItem cartItem = null;

	    Product product;
	    try {
	        product = productDao.getProductById(orderDetail.getProduct_id());
	        if (product != null) {
	            cartItem = new CartItem();
	            cartItem.setProductId(product.getProduct_id());
	            cartItem.setProductName(product.getProduct_name());
	            cartItem.setPrice(product.getPrice());
	            cartItem.setProductImg(product.getProduct_img());
	            cartItem.setQuantity(orderDetail.getQuantity());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cartItem;
	}

}
