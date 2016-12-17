package com.ims.model;

public class ProductDetails {
	int id;
	String brand;
	String model;
	String version;
	boolean active;
	String expirationDate;
	float netPrice;
	float grossPrice;
	float taxPercentage;
	float discountPercentage;
	String accessories;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public float getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}
	public float getGrossPrice() {
		return grossPrice;
	}
	public void setGrossPrice(float grossPrice) {
		this.grossPrice = grossPrice;
	}
	public float getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(float taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	public float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getAccessories() {
		return accessories;
	}
	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}


}
