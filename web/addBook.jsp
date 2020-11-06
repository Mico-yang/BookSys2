<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/16 0016
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>增加图书信息</h2>
<form action="BookInfoServlet" method="post">
    <input type="hidden" name="method" value="insert"/>
    图书名称：<input type="text" name="book_name"/></br>
    图书价格：<input type="text" name="book_price"/></br>
    图书作者：<input type="text" name="book_author"/></br>
    图书出版社：<input type="text" name="book_pub"/></br>
图书类型：<select name="type_id">
    <c:forEach items="${tlist}" var="type">
        <option value="${type.type_id}">${type.type_id}---${type.type_name}</option>
    </c:forEach>
</select></br>
    图书状态：<input type="radio" name="book_state" value="0" />未借出
<input type="radio" name="book_state" value="1" checked="checked"/>已借出</br>
<input type="submit" value="增加"/>
<input type="reset" value="重置"/>
</form>
</body>
</html>
