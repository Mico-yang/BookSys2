<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/16 0016
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="BookTypeServlet">增加</a>
<table border="1" width="800">
    <tr>
        <th>图书编号</th><th>图书名称</th><th>图书作者</th>
        <th>图书价格</th><th>图书出版社</th><th>图书状态</th>
        <th>图书分类</th><th>操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="book">
        <tr>
            <td>${book.book_id}</td>
            <td>${book.book_name}</td>
            <td>${book.book_author}</td>
            <td>${book.book_price}</td>
            <td>${book.book_pub}</td>
            <td>${book.book_state==0?'未借出':'已借出'}</td>
            <td>${book.type_id}</td>
            <td><a href="#">详情</a><a href="javascript:deleteBook(${book.book_id})">删除</a><a href="BookInfoServlet?method=findOne&id=${book.book_id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<script>
    function deleteBook(book_id){
        //alert("Warning!!!"+book_id);
        if (confirm("确认删除?")){
            window.location.href="BookInfoServlet?method=delete&id="+book_id;
        }
    }
</script>
</body>
</html>
