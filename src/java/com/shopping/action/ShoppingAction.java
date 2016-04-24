package com.shopping.action;

import java.util.List;

import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;

public class ShoppingAction {
	
	private ShoppingService shoppingService;
	private ProductDto productDto;
	private List<ProductDto> productList;
	
	public String addProduct( ){
		this.shoppingService.addProduct(productDto);
		return "success";
	}
	
	public String queryProduct(){
		productList = this.shoppingService.queryProductList(productDto);
		return "success";
	}

	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

}
