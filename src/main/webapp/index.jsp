<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'"><br>
<table>
    <c:forEach items="${taskList}" var="message">
        <tr>
            <td>
                    ${message.taskTitle}
            </td>
            <td>
                <a href="/details?task=${message.taskId}">
                <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                ${message.messagesValues}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
