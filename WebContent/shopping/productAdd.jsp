<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="addProductAction" method="post" package="/shopping" enctype="multipart/form-data">
<!-- productDto is the argu of 
	this.shoppingService.addProduct(productDto);
in 
	public String addProduct( ){
		this.shoppingService.addProduct(productDto);
		return "success";
	}
 -->
	<s:textfield name="productDto.productName" label="product name" />
	<s:textfield name="productDto.productPrice" label="price" />
	<s:textfield name="productDto.productType" label="productType" />
	<s:radio label="product status" list="#{'M':'boy','F':'girl','o':'others' }" name="productDto.productStatus" />
	<s:textfield name="productDto.productCount" label="product count" />
	<s:textfield name="productDto.productImage" label="product image" />
	<s:textfield name="productDto.productRemark" label="product remark" />
	<s:textfield name="productDto.createBy" label="creater" />
	<s:textfield name="productDto.createTime" label="create time" />
	<s:textfield name="productDto.updateBy" label="update by" />
	<s:textfield name="productDto.updateTime" label="update time" />
	
	<s:submit value="submit"></s:submit>
	<s:reset value="reset"></s:reset>
	
</s:form>

</body>
</html>