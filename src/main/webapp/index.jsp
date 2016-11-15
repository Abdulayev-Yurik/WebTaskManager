<%--<jsp:useBean id="taskList" scope="request" type="java.util.List<model.Task>"/>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'"><br>
<table>
    <tr></tr>
    <tr></tr>
    <tr><h2>Active Tasks</h2></tr>
    <c:forEach items="${taskList}" var="task">
        <tr>
            <td>
                    ${task.taskTitle}
            </td>
            <c:if test="${task.active}">
                <td title="close task">
                    <a href="/taskState?task=${task.taskId}">
                        <i class="material-icons" style="font-size:20px; color: greenyellow">done_all</i>
                    </a>
                </td>
            </c:if>
            <c:if test="${!task.active}">
                <td title="reopen task">
                    <a href="/taskState?task=${task.taskId}">
                        <i class="material-icons" style="font-size:20px; color: greenyellow">add_to_queue</i>
                    </a>
                </td>
            </c:if>
            <td>
                <a href="/details?task=${task.taskId}">
                    <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                        ${task.messagesValues}</a>
            </td>
            <td>
                <a href="/delete?task=${task.taskId}">
                    <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
