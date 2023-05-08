package ecommerce.com.models;

import java.math.BigDecimal;

public class product {
	int product_id, quantity;
	String description, product_name;
	BigDecimal price;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public product() {
		super();
	}

	public product(int product_id, int quantity, String description, String product_name, BigDecimal price) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.description = description;
		this.product_name = product_name;
		this.price = price;
	}

}
