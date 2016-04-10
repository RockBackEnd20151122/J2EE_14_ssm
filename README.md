

based on J2EE_12_layer

if:
Referenced file contains errors (http://www.springframework.org/schema/beans/spring-beans.xsd). For more information, right click on the message in the Problems 
 View and select "Show Details..."
means internet doesn't work;

1. jars:
struts ....


2. config for spring:
add applicationContext_base.xml 
	under:/Users/dihwang/workspace-sts-3.7.2.RELEASE/java/J2EE_13_ssm/src/config/spring

add: 
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring/applicationContext*.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
	to web.xml

add:
	<bean id="propertyConfigurer"
		class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>/WEB-INF/classes/mybatis/jdbc.properties</value>
			</list>
		</property>
	</bean>

	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="${jdbc.driverClassName}" />
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
	</bean>
	to applicationContext_base.xml
	
add: 
	/Users/dihwang/workspace-sts-3.7.2.RELEASE/java/J2EE_13_ssm/src/config/mybatis/jdbc.properties
	
delete unused lines in mybatis-config.xml


3.struts fold of:
	move struts.xml into folder struts
	move user.xml into
	add :
	<include file="struts-default.xml"></include>
	<include file="struts-plugin.xml"></include>
	changes inside struts.xml: 
	<include file="user.xml"></include> to: <include file="struts/user.xml"></include>
	changes inside web.xml, is add:
	<init-param>
      <param-name>config</param-name>
      <param-value>/struts/struts.xml</param-value>
    </init-param>

4. 事务：
(4):事务的特性(ACID特性)
A:原子性(Atomicity)
事务是数据库的逻辑工作单位，事务中包括的诸操作要么全做，要么全不做。
B:一致性(Consistency)
事务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。一致性与原子性是密切相关的。
C:隔离性(Isolation)
一个事务的执行不能被其他事务干扰。
D:持续性/永久性(Durability)
一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。
注:事务是恢复和并发控制的基本单位。

add:
<!-- for '事务' -->
	<bean name="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	<tx:advice id="userTxAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="delete*" propagation="REQUIRED" />
			<tx:method name="insert*" propagation="REQUIRED" />
			<tx:method name="add*" propagation="REQUIRED" />
			<tx:method name="update*" propagation="REQUIRED" />
			<tx:method name="find*" propagation="SUPPORTS" />
			<tx:method name="get*" propagation="SUPPORTS" />
			<tx:method name="select*" propagation="SUPPORTS" />
		</tx:attributes>
	</tx:advice>
	<aop:config>
		<aop:pointcut id="serviceMethod" expression="execution(* *..*Service.*(..))" />
		<aop:advisor pointcut-ref="serviceMethod" advice-ref="userTxAdvice" />
	</aop:config>

	to applicationContext_base.xml
	
add:
		this.userDao.addUser(user);
		this.userDao.addUser(user);
		//here is for test 事务
	to /Users/dihwang/workspace-sts-3.7.2.RELEASE/java/J2EE_13_ssm/src/java/com/user/service/impl/UserServiceImpl.java
	inside addUser();
	
change in /Users/dihwang/workspace-sts-3.7.2.RELEASE/java/J2EE_13_ssm/src/config/mybatis/user.xml:
<mapper namespace="com.user.dao.UserDao">
to match the currect dao
	
test, use login to test;
	
to be continue ....
	
