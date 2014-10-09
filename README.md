tomcat-spring-jndi-test
=======================

Little test for JNDI datasources under tomcat and spring

## Usage

```shell
cd DataSourceTest
gradle run
```

then enter in browser:

```
http://localhost:9090/DataSourceTest/dynamic
```

You should see:

```
Hello, world!725046289, URL=jdbc:mysql://172.17.0.8:3306/test, UserName=user1@172.17.42.1, MySQL Connector Java
```

That means: jdbc connector was successfully instantiated.

*Important*: you need to enter specific url, username and password in "webapp-config/context.xml".
