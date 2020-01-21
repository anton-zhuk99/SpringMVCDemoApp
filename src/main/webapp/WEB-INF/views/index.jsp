<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Notes Application</title>
    <style type="text/css">
        body {
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: Calibri, serif;
        }

        .globalWrapper {
            background-color: darkgrey;
            margin: auto;
            width: 25%;
            padding: 15px;
            display: inline-block;
            border-radius: 25px;
            align-items: center;
            justify-content: center;
        }

        .headerWrapper {
            text-align: center;
            background-color: lightgray;
            padding: 10px;
            border-radius: 15px;
            width: 50%;
            margin: auto;
            margin-bottom: 10px;
        }

        .addNewNoteButton:link, .addNewNoteButton:visited {
            background-color: #e0ded9;
            color: black;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
        }

        .addNewNoteButton:hover, .addNewNoteButton:active {
            opacity: 90%;
        }

        .noteHeader {
            margin: 5px;
            vertical-align: middle;
            font-family: Consolas, monospace;
        }

        .noteWrapper {
            display: grid;
            grid-template-columns: auto auto auto;
            text-align: center;
            margin-bottom: 10px;
        }

        .noteHeaderWrapper, .editNoteButtonWrapper, .deleteNoteButtonWrapper {
            background-color: slategrey;
            color: whitesmoke;
            height: content-box;
        }

        .noteHeaderWrapper {
            border-top-left-radius: 10px;
        }

        .deleteNoteButtonWrapper {
            border-top-right-radius: 10px;
        }

        .noteTextBlock {
            grid-column-start: 1;
            grid-column-end: 4;
            background-color: steelblue;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
        }

        .editNoteButton:link, .editNoteButton:visited {
            vertical-align: middle;
            color: lightgrey;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .editNoteButton:hover, .editNoteButton:active {
            text-decoration: underline;
        }

        .deleteNoteButton:link, .deleteNoteButton:visited {
            vertical-align: middle;
            color: lightgrey;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .deleteNoteButton:hover, .deleteNoteButton:active {
            text-decoration: underline;
        }

        .noteText {
            color: whitesmoke;
            font-style: italic;
            font-family: "Bookman Old Style", serif;
        }
    </style>
</head>
<body>
    <div class="globalWrapper">
        <div class="headerWrapper">
            <h1 class="header">Your notes</h1>
            <a class="addNewNoteButton" href="${pageContext.request.contextPath}/addNewNote">Add new note</a>
        </div>
        <c:forEach var="note" items="${noteList}" varStatus="status">
            <div class="noteWrapper">
                <div class="noteHeaderWrapper">
                    <p class="noteHeader">Note from ${note.date} ${note.time}</p>
                </div>
                <div class="editNoteButtonWrapper">
                    <a class="editNoteButton" href="${pageContext.request.contextPath}/editNote?id=${note.id}">
                        Edit
                    </a>
                </div>
                <div class="deleteNoteButtonWrapper">
                    <a class="deleteNoteButton" href="${pageContext.request.contextPath}/deleteNote?id=${note.id}">
                        Delete
                    </a>
                </div>
                <div class="noteTextBlock">
                    <p class="noteText">
                        "${note.text}"
                    </p>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>