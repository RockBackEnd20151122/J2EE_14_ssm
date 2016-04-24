<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>productId</th>
			<th>productName</th>
			<th>productPrice</th>
			<th>account</th>
			<th>productDiscount</th>
			<th>productImage</th>
			<th>productRemark</th>
		</tr>
		<s:form action="updateShopCartAction" namespace="/shopping" theme="simple">
			<!-- 迭代器，类似于java中的foreach语句 -->
			<s:iterator value="shoppingCardList" id="productDto">
				<tr>
					<input type="hidden" name="productIdList"
						value='<s:property value="#productDto.productId" />'>
					<td><s:property value="#productDto.productId" /></td>
					<td><s:property value="#productDto.productName" /></td>
					<td><s:property value="#productDto.productPrice" /></td>
					<td><input type="text" name="productCountList"
						value='<s:property value="#productDto.productBuyCount" />'></td>
					<td><s:property value="#productDto.productDiscount" /></td>
					<td><s:property value="#productDto.productImage" /></td>
					<td><s:property value="#productDto.productRemark" /></td>
				</tr>
			</s:iterator>

			<s:submit value="提交"></s:submit>
		</s:form>
	</table>
</body>
</html>