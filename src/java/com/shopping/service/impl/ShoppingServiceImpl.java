package com.shopping.service.impl;

import java.util.Date;

import com.shopping.dao.ProductDao;
import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;
import com.user.util.BaseUtils;

public class ShoppingServiceImpl implements ShoppingService {
	
	private ProductDao productDao;

	@Override
	public void addProduct( ProductDto product ) {
		// TODO Auto-generated method stub
		
		Date time = new Date();
		product.setProductId(BaseUtils.getUUID() );
		
		product.setCreateTime(time);
		product.setUpdateTime(time);

		//spring 相当于有一个dao的实现类
		this.productDao.addProduct(product);
		//here is for test 事务
	
	}

	@Override
	public void adjustProduct( ProductDto product ) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void removeProductById( String id ) {
		// TODO Auto-generated method stub

	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
