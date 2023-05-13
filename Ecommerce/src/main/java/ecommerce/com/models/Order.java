package ecommerce.com.models;

import java.util.Date;

public class Order {
	int order_id, user_id;
	Date order_date;
	String order_status;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int order_id, int user_id, Date order_date, String order_status) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_date = order_date;
		this.order_status = order_status;
	}
	public Order(int order_id, int user_id, String order_status) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_status = order_status;
	}
	

}
