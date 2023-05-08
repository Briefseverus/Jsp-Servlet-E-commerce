package ecommerce.com.models;

public class orderdetail {
	int order_detail_id;
	int order_id;
	int product_id, quantity;
	public int getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public orderdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderdetail(int order_detail_id, int order_id, int product_id, int quantity) {
		super();
		this.order_detail_id = order_detail_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	
}
