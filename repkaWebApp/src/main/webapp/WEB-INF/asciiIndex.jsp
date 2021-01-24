<%@ page import="java.util.ArrayList" %>
<%--<%@ page import="ua.repka.Models.User" %>&lt;%&ndash;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <title>AsciiConverter</title>
</head>
<body>
<p>Today <%= new java.util.Date() %></p>
<form method="post" action="<c:url value="/toAscii"/>">
    <label for="word"> Word to convert
        <input type="text" id="word" name="asciiString">
    </label>
    <br><br>
    <label> Ascii_type:
        <input type="radio" name="asciiType" value="1" checked /> First
        <input type="radio" name="asciiType" value="2" /> Second
    </label>
    <br><br>
    <input type="submit" name="Convert">
</form>

<table>
    <tr>
        <th> Word in another style</th>
    </tr>
    <c:if test="${!empty asciiList}">
        <ul>
            <c:forEach items="${asciiList}" var="current">
                <tr>
                    <td>
                        <pre> <c:out value="${current}"/> </pre>
                    <td>
                </tr>
            </c:forEach>
        </ul>
    </c:if>

</table>
<a href='<c:url value="/hello" />'><c:url value="/hello" /></a>
</body>
</html>
