package com.shopping.service;

import java.util.List;

import com.shopping.dto.ProductDto;

public interface ShoppingService {
	
	void addProduct( ProductDto product );
	
	void adjustProduct( ProductDto product );
	
	void removeProductById( String id );
	
	List<ProductDto> queryProductList(ProductDto productDto);
	
	ProductDto queryProduct( String id );
	
}