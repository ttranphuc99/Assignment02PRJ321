<%-- 
    Document   : index
    Created on : May 30, 2019, 8:57:27 AM
    Author     : Thien Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search brand</h1>
        <a href="insert.jsp">Insert accessory</a>
        <form action="MainController" method="POST">
            Brand: <input type="text" name='txtSearch' value="${param.txtSearch}" required/>

            <input type="submit" name="action" value="Search"/>
        </form>

        <c:if test="${requestScope.RESULT != null}">
            <c:if test="${not empty requestScope.RESULT}" var="checkResult">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>AccessoryID</th>
                            <th>AccessoryName</th>
                            <th>Brand</th>
                            <th>Price</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.RESULT}" var="dto" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td>${dto.id}</td>
                            <td>${dto.name}</td>
                            <td>${dto.brand}</td>
                            <td>${dto.price}</td>
                            <td>
                                <c:url var="deleteLink" value="MainController">
                                    <c:param name="action" value="Delete"/>
                                    <c:param name="id" value="${dto.id}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="hidden" name="id" value="${dto.id}"/>
                                    <input type="submit" name="action" value="Edit"/>
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkResult}">
                <font color='red'>Not found</font>
            </c:if>
        </c:if>
    </body>
</html>
