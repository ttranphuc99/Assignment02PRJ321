<%-- 
    Document   : insert
    Created on : Jun 11, 2019, 10:40:28 AM
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
        <h1>Insert Accessory</h1>
        
        <form action="MainController" method="POST">
            ID: <input type="text" name="txtID" value="${param.txtID}" />
            <font color='red'>${requestScope.INVALID.errorID}</font><br/>
            
            Name: <input type="text" name="txtName" value="${param.txtName}"/>
            <font color='red'>${requestScope.INVALID.errorName}</font><br/>
            
            Brand: <input type="text" name="txtBrand" value="${param.txtBrand}"/>
            <font color='red'>${requestScope.INVALID.errorBrand}</font><br/>
            
            Description: <input type="text" name="txtDes" value="${param.txtDes}"/>
            <font color='red'>${requestScope.INVALID.errorDes}</font><br/>
            
            Price: <input type="text" name="txtPrice" value="${param.txtPrice}"/>
            <font color='red'>${requestScope.INVALID.errorPrice}</font><br/>
            
            <input type="submit" name="action" value="Insert"/>
        </form>
    </body>
</html>
