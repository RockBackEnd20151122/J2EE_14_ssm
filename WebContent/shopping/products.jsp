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

	<s:form action="queryProductAction" id="productForm"
		namespace="/shopping">
		<s:textfield name="productDto.productName" label="商品名" />
		<s:select label="商品类型" list="#{'001':'水果','002':'其他' }"
			name="productDto.productType"></s:select>
		<s:textfield name="productDto.productPriceStart" label="价格开始" />
		<s:textfield name="productDto.productPriceEnd" label="价格结束" />
		<s:submit value="查询"></s:submit>
	</s:form>

	<table border="1">
		<tr>
			<th>商品名称</th>
			<th>价格</th>
			<th>商品类别</th>
			<th>商品状态</th>
			<th>库存</th>
			<th>折扣</th>
			<th>图片</th>
			<th>注释</th>
			<th>操作</th>
		</tr>
		<!-- 迭代器，类似于java中的foreach语句 -->
		<s:iterator value="productList" id="productInfo">
			<tr>
				<!--s:property方法是获取变量的值。下面的语法相当于调用uesrInfo.getName()方法  -->
				<td><s:property value="#productInfo.productName" /></td>
				<td><s:property value="#productInfo.productPrice" /></td>
				<td><s:property value="#productInfo.productType" /></td>
				<td><s:property value="#productInfo.productStatus" /></td>
				<td><s:property value="#productInfo.productCount" /></td>
				<td><s:property value="#productInfo.productDiscount" /></td>
				<td><s:property value="#productInfo.productImage" /></td>
				<td><s:property value="#productInfo.productRemark" /></td>
				<td><s:url id="url" action="addShoppingCartAction"
						namespace="/shopping">
						<s:param name="productDto.productId">
							<s:property value="#productInfo.productId" />
						</s:param>
					</s:url> <s:a href="%{url}"> 添加购物车</s:a></td>
			</tr>
		</s:iterator>


		<tr>
			<td><s:url id="url" action="queryShopCartAction"
					namespace="/shopping">
				</s:url> <s:a href="%{url}"> 查看购物车</s:a></td>
		</tr>
	</table>


	<!-- <table border="1" bordercolor="black">
		<tr>
			<td>productName</td>
			<td>productPrice</td>
			<td>productType</td>
			<td>productStatus</td>
			<td>productCount</td>
			<td>productImage</td>
			<td>productRemark</td>
			<td>createBy</td>
			<td>createTime</td>
			<td>updateBy</td>
			<td>updateTime</td>
		</tr>
		<tr>
			<c:if test="${empty result}">Sorry, u don't have data!</c:if>
			<c:if test="${not empty result}">
				<c:forEach var="product" items="${result}">
					<tr>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productType}</td>
						<td>${product.productStatus}</td>
						<td>${product.productCount}</td>
						<td>${product.productImage}</td>
						<td>${product.productRemark}</td>
						<td>${product.createBy}</td>
						<td>${product.createTime}</td>
						<td>${product.updateBy}</td>
						<td>${product.updateTime}</td>
						<td>
							<c:url var="url" value="/deleteProductAction">
								<c:param name="productId">${product.productId}</c:param>
							</c:url>
							<a href="${url}">delete</a>
							
							<c:url var="url" value="/updateProductAction">
								<c:param name="productId">${user.userId}</c:param>
							</c:url>
							<a href="${url}">modify</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tr>
	</table>  -->
</body>
</html>