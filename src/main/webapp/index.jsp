<jsp:useBean id="taskActiveList" scope="request" type="java.util.List<model.Task>"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="page">
    <input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'"><br>
    <c:if test="${taskActiveList.size() != 0}">
        <div class="activeList">
            <table>
                <tr></tr>
                <tr></tr>
                <tr><h2>Active Tasks</h2></tr>
                <c:forEach items="${taskActiveList}" var="task">
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
        </div>
    </c:if>
    <c:if test="${taskDoneList.size() != 0}">
        <div class="doneList">
            <table>
                <tr></tr>
                <tr></tr>
                <tr><h2>Done tasks</h2></tr>
                <c:forEach items="${taskDoneList}" var="task">
                    <tr>
                        <td>
                                ${task.taskTitle}
                        </td>
                        <c:if test="${!task.active}">
                            <td title="reopen task">
                                <a href="/taskState?task=${task.taskId}">
                                    <i class="material-icons"
                                       style="font-size:20px; color: greenyellow">add_to_queue</i>
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
        </div>
    </c:if>
</div>
</body>
</html>
