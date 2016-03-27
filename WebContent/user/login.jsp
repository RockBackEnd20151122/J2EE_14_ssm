<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#errMsg{
	color:red;
}
</style>
</head>
<body>

<div id="errMsg">${message}</div>

<s:form action="loginAction" method="post" package="/user" >
	<s:textfield name="userDto.userName" label="userName" />
	<s:password name="userDto.password" label="password" ></s:password>
	
	<s:submit value="submit"></s:submit>
	<s:reset value="reset"></s:reset>
	
	<s:a href="../user/register.jsp">register</s:a>
	
</s:form>

</body>
</html>