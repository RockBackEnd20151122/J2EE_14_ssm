
based on J2EE_13_ssm

20160417: start products maintain 

20160508:
verify session of if user logged in;

1. add to struts.xml:
	<package name="myBasePackage" extends="struts-default">
		<interceptors>
			<interceptor name="authority"
				class="util.interceptors.LoginInterceptor" />
			<interceptor-stack name="myStack">
				<interceptor-ref name="authority" />
				<interceptor-ref name="defaultStack" />
			</interceptor-stack>
		</interceptors>
		<default-interceptor-ref name="myStack" />

		<global-results>
			<result name="login">/common/login.jsp</result>
		</global-results>

	</package>


2. copy files:
util/interceptors/LoginInterceptor.java
util/BaseUtil.java


3.
change the order

<interceptor-ref name="defaultStack" />
<interceptor-ref name="authority" />

4.
    <package name="shopping" namespace="/shopping" extends="struts-default">
    change to:
    <package name="shopping" namespace="/shopping" extends="myBasePackage">


5. copy
WebContent/common/login.jsp

6. add ssm.user to DB:
CREATE TABLE `user` (
  `user_id` varchar(36) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `real_name` varchar(100) NOT NULL,
  `password` varchar(36) NOT NULL,
  `register_time` datetime NOT NULL,
  `gender` varchar(2) ,
  `birthday` date ,
  `head_image` varchar(100) ,
  `user_status` varchar(2) NOT NULL,
  `create_by` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(100) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

7，### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '93dfb457-b80c-41d9-a6bd-d8ccad10425e' for key 'PRIMARY'

because：
/Users/dihwang/workspace-sts-3.7.2.RELEASE/java/J2EE_14_ssm/src/java/com/user/service/impl/UserServiceImpl.java   have 事务 test code；

//this.userDao.addUser(user);

8.			//TODO: set the previous url to session and go back;



9.



	
to be continue ....
	
