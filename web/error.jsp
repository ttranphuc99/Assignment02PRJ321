<%-- 
    Document   : error
    Created on : Jun 11, 2019, 11:43:03 AM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error</h1>
        <font color='red'>${requestScope.ERROR}</font>
        
        <a href="index.jsp">Back to home</a>
    </body>
</html>
