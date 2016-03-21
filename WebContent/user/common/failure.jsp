<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="addUserAction" method="post" pachage="/user" enctype="multipart/form-data">
	<s:textfield name="userDto.userName" label="userName" />
	<s:textfield name="userDto.realName" label="real name" />
	<s:password name="userDto.password" label="password" ></s:password>
	<s:radio label="sex" list="#{'M':'boy','F':'girl','o':'others' }" name="userDto.gender" />
	<s:textfield name="userDto.birthday" label="birthday" />
	<s:file name="files" label="protrait" />
	
	<s:sumit value="submit"></s:sumit>
	<s:reset value="reset"></s:reset>
	
</s:form>

</body>
</html>