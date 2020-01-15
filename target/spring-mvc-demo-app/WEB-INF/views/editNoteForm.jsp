<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 1/15/2020
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit note</title>
</head>
<body>
<div align="center">
    <h1>Edit note</h1>
    <form:form action="updateNote" method="post" modelAttribute="note">
        <table>
            <form:hidden path="id"/>
            <form:hidden path="date"/>
            <form:hidden path="time"/>
            <tr>
                <td><form:textarea path="text"/></td>
            </tr>
            <tr>
                <td align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
