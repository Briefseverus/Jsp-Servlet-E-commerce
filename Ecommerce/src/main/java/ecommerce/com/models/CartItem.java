package ecommerce.com.models;

import java.math.BigDecimal;
import java.sql.SQLException;

import ecommerce.com.daos.ProductDao;

public class CartItem {
	private int productId;
	private String productName;
	private BigDecimal price;
	private int quantity;
	private String productImg;

	public CartItem(int productId, String productName, BigDecimal price, int quantity, String productImg) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productImg = productImg;
	}

	public CartItem(int productId, int quantity) {
		ProductDao productDao = new ProductDao();
		Product pro;
		try {
			pro = productDao.getProductById(productId);
			this.productId = productId;
			this.productName = pro.getProduct_name();
			this.price = pro.getPrice();
			this.quantity = quantity;
			this.productImg = pro.getProduct_img();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public BigDecimal getTotalPrice() {
		return price.multiply(BigDecimal.valueOf(quantity));
	}
}
