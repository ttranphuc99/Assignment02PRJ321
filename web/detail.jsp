<%-- 
    Document   : detail
    Created on : Jun 11, 2019, 12:00:49 PM
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
        <h1>Detail</h1>
        
        <form action="MainController" method="POST">
            ID: <input type="text" name="txtID" value="${requestScope.DTO.id}" readonly/>
            <font color='red'>${requestScope.INVALID.errorID}</font><br/>
            
            Name: <input type="text" name="txtName" value="${requestScope.DTO.name}"/>
            <font color='red'>${requestScope.INVALID.errorName}</font><br/>
            
            Brand: <input type="text" name="txtBrand" value="${requestScope.DTO.brand}"/>
            <font color='red'>${requestScope.INVALID.errorBrand}</font><br/>
            
            Description: <input type="text" name="txtDes" value="${requestScope.DTO.description}"/>
            <font color='red'>${requestScope.INVALID.errorDes}</font><br/>
            
            Price: <input type="text" name="txtPrice" value="${requestScope.DTO.price}"/>
            <font color='red'>${requestScope.INVALID.errorPrice}</font><br/>
            
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
