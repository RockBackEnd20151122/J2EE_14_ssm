package com.shopping.dao;

import java.util.List;

import com.shopping.dto.ProductDto;

public interface ProductDao {
	
	/* all functions will be implemented by myBatis */
	
	void addProduct( ProductDto pro );
	
	public ProductDto getProductByID (String id);
	
	public List<ProductDto> queryProductList(ProductDto productDto);
	
}
