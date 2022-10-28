package kr.co.Shop.bean;

import java.util.Set;

public class OrderBean {
	private String orderNo;
	private String orderId;
	private String orderProduct;
	private String orderCount;
	private String orderDate;
	
	//추가필드
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String prodName;
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
