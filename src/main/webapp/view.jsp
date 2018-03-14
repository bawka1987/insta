<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bawka.Model.Picture" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: newadmin
  Date: 13.03.2018
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% ArrayList<Picture>pictures = (ArrayList<Picture>)request.getAttribute("pictures"); %>
<c:forEach items="${pictures}" var="item">
  <c:out value="${item.id}"/>
</c:forEach>


</body>
</html>
