<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Notes Application</title>
</head>
<body>
<div align="center">
    <h1>Your notes</h1>
    <form:form method = "GET" action = "/addNewNote">
        <table>
            <tr>
                <td>
                    <input type = "submit" value = "Add new note"/>
                </td>
            </tr>
        </table>
    </form:form>
    <table border="1">
        <c:forEach var="note" items="${noteList}" varStatus="status">
            <tr>
                <td>
                    <h5>Note #${status.index + 1} from ${note.date} ${note.time}</h5>
                    <p>
                        ${note.text}
                    </p>
                </td>
                <td>
                    <a href="/editNote?id=${note.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>