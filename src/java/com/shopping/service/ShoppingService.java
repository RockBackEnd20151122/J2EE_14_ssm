package com.shopping.service;

import com.shopping.dto.ProductDto;

public interface ShoppingService {
	
	void addProduct( ProductDto product );
	
	void adjustProduct( ProductDto product );
	
	void removeProductById( String id );

}