package com.shopping.dao;

import com.shopping.dto.ProductDto;

public interface ProductDao {
	
	void addProduct( ProductDto pro );
	
	ProductDto getProductByProductId (String id);

}
