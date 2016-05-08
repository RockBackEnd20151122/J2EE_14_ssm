<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	</script>
	<div id="errorMessage">${message}</div>
	<s:form action="loginAction" namespace="/user">
		<s:textfield name="userDto.userName" label="名称" value="test001" />
		<s:password name="userDto.password" label="密码" value="test001"></s:password>
		<s:submit value="登陆"></s:submit>
		<s:reset value="重置"></s:reset>

		<s:a href="../user/register.jsp">注册</s:a>
	</s:form>

</body>
</html>