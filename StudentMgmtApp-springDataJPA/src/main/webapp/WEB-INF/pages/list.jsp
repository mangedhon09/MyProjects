<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 30px;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #28a745;
            padding: 8px 12px;
            border-radius: 4px;
            margin: 10px;
            display: inline-block;
        }

        a:hover {
            background-color: #218838;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            background-color: white;
        }

        th {
            background-color: #007BFF;
            color: white;
            padding: 10px;
        }

        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .action-links a {
            color: #007BFF;
            background-color: transparent;
            padding: 4px 8px;
            border-radius: 3px;
            margin: 0 4px;
        }

        .action-links a:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>

<h2>Student List</h2>

<div style="text-align:center;">
    <a href="${pageContext.request.contextPath}/students/add">Add New Student</a>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.course}</td>
            <td class="action-links">
                <a href="${pageContext.request.contextPath}/students/edit/${student.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/students/delete/${student.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
