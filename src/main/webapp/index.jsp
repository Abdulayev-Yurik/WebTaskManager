<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'"><br>
<table>
    <jsp:useBean id="taskList" scope="request" type="java.util.List<model.Task>"/>
    <c:forEach items="${taskList}" var="item">
        <tr>
            <td>
                    ${item.taskTitle}
            </td>
            <td>
                <a href="/messages?task=${item.taskId}">
                <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                ${item.messagesValues}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
