
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>请给我100分</title>
  </head>
  <body>
  <c:if test="${cookieScope.autologin !=null}">
    <jsp:forward page="controller.jsp"></jsp:forward>
  </c:if>
    <jsp:forward page="login.jsp"></jsp:forward>
  </body>
</html>
