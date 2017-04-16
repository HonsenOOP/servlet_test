<%--
  Created by IntelliJ IDEA.
  User: Nastu
  Date: 2016/9/5
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:useBean id="hello" class="HelloModel" scope="request">
</jsp:useBean>
<jsp:setProperty name="hello" property="*"/>
<%
    if ("nazi".equals(hello.getName())){
%>
    <jsp:forward page="/hello"></jsp:forward>
<%
    }
%>
    <form action="login.jsp" method="post">
        <input type="hidden" name="name" value="nazi">
        <input type="submit" value="submit">
    </form>
</body>

</html>
