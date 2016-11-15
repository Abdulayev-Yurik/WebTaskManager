<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<form action="/messages">
    <input type="hidden" name="task" value="${task.taskId}">
    <input type="text" placeholder="Enter new message" name="n_message" required>
    <input type="submit" value="Add message">
</form>
<table>
    <tr>
        <td>Task title: ${task.taskTitle}</td>
    </tr>
    <tr></tr>
    <tr></tr>
    <c:forEach items="${task.messages}" var="message">
        <tr>
            <td>
                    ${message.taskTitle}
            </td>
            <td>
                <a href="/messages?task=${message.taskId}">
                    <i class="material-icons" style="color: green; font-size:14px">announcement</i>
                        ${message.messagesValues}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
