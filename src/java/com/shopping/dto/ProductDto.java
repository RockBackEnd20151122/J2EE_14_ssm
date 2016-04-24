package com.shopping.dto;

import java.util.Date;

public class ProductDto {

	private String productId;
	private String productName;
	private Double productPrice;
	private String productType;
	private String productStatus;
	private int productCount;
	private Double productDiscount;
	private String productImage;
	private String productRemark;
	private String createBy;
	private Date createTime;
	private String updateBy;
	private Date updateTime;
	
	private Double productPriceStart;
	private Double productPriceEnd;
	
	private int productBuyCount;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public Double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Double getProductPriceStart() {
		return productPriceStart;
	}
	public void setProductPriceStart(Double productPriceStart) {
		this.productPriceStart = productPriceStart;
	}
	public Double getProductPriceEnd() {
		return productPriceEnd;
	}
	public void setProductPriceEnd(Double productPriceEnd) {
		this.productPriceEnd = productPriceEnd;
	}
	public int getProductBuyCount() {
		return productBuyCount;
	}
	public void setProductBuyCount(int productBuyCount) {
		this.productBuyCount = productBuyCount;
	}
}
