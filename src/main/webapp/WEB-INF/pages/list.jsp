<%--
  Created by IntelliJ IDEA.
  User: haowu
  Date: 2019/12/16
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
查询了所有
<c:forEach items="${list}" var="account">
    ${account.id}
    ${account.uid}
    ${account.money}
</c:forEach>
</body>
</html>
