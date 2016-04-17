package com.shopping.action;

import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;

public class ShoppingAction {
	
	private ShoppingService shoppingService;
	private ProductDto productDto;
	
	public String addProduct( ){
		this.shoppingService.addProduct(productDto);
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

}
