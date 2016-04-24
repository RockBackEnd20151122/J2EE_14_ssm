package com.shopping.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;

public class ShoppingAction extends ActionSupport {
	
	private ShoppingService shoppingService;
	private ProductDto productDto;
	private List<ProductDto> productList;
	private String message;
	
	private HttpSession httpSession;
	
	private Integer productBuyAccount;
	private List<ProductDto> shoppingCardList; 
	
	public String addProduct( ){
		this.shoppingService.addProduct(productDto);
		
		productList = this.shoppingService.queryProductList(productDto);
		if( productList.isEmpty()){
			return "success";
		}else{
			return "list";
		}
	}
	
	
	
	public String queryProduct(){
		try {
			productList = this.shoppingService.queryProductList(productDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getLogger("FILE").debug(e);
			Logger.getLogger("FILE").debug(e.getStackTrace());
			
			Logger.getLogger("FILE").error(e.getMessage(), e);		//log and line of error
			
			this.message = "search error";
//			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String addShoppingCart(){
		try {
			httpSession= ServletActionContext.getRequest().getSession();
			Map<String, Integer> shoppingCardMap = (Map<String, Integer>) httpSession.getAttribute("shoppingCard");
			if(shoppingCardMap==null ){
				shoppingCardMap = new HashMap<String, Integer>();
			}
			Integer count = shoppingCardMap.get(productDto.getProductId());
			if( count ==null ){
				count = 0;
			}
			count++;
			shoppingCardMap.put( productDto.getProductId(), count );
			httpSession.setAttribute( "shoppingCard", shoppingCardMap );
			System.out.println(shoppingCardMap);
			this.message = "adding succeed";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getLogger("FILE").error(e.getMessage(), e);//error and line of code
			this.message = "adding process not currect";
//			e.printStackTrace();
			return this.ERROR;
		}
		return this.SUCCESS;
	}
	
	public String queryShoppingCard(){
		httpSession= ServletActionContext.getRequest().getSession();
		Map<String, Integer> shoppingCardMap = (Map<String, Integer>) httpSession.getAttribute("shoppingCard");
		
		if( shoppingCardMap!=null && shoppingCardMap.size()>0 ){
			this.shoppingCardList = new ArrayList<ProductDto>();
			for( String productId: shoppingCardMap.keySet() ){
				ProductDto productDtoTemp = this.shoppingService.queryProduct(productId);
				productDtoTemp.setProductBuyCount(shoppingCardMap.get(productId));
				this.shoppingCardList.add(productDtoTemp);
			}
		}
		return this.SUCCESS;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}



	public Integer getProductBuyAccount() {
		return productBuyAccount;
	}



	public void setProductBuyAccount(Integer productBuyAccount) {
		this.productBuyAccount = productBuyAccount;
	}

	public List<ProductDto> getShoppingCardList() {
		return shoppingCardList;
	}

	public void setShoppingCardList(List<ProductDto> shoppingCardList) {
		this.shoppingCardList = shoppingCardList;
	}

}
