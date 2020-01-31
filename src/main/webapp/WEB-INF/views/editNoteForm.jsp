<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New note</title>
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
            width: auto;
            padding: 15px;
            display: inline-block;
            border-radius: 25px;
            text-align: center;
        }

        .formWrapper {
            display: grid;
            grid-template-columns: auto;
            grid-gap: 10px;
            padding: 10px;
        }

        .submitButton {
            margin: auto;
            width: 25%;
        }
    </style>
</head>
<body>
<div class="globalWrapper">
    <div class="headerWrapper">
        <h1 class="header">Edit note</h1>
    </div>
    <form:form action="updateNote" method="post" modelAttribute="note">
        <div class="formWrapper">
            <div class="textareaWrapper">
                <form:hidden path="id"/>
                <form:hidden path="date"/>
                <form:hidden path="time"/>
                <form:textarea rows="5" cols="30" path="text" />
            </div>
            <div class="submitButtonWrapper">
                <input class="submitButton" type="submit" value="Save">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>