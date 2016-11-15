<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<a href="/home">Back</a>
<form action="/messages">
    <input type="hidden" name="taskId" value="${task.taskId}">
    <input type="text" placeholder="Enter new message" name="n_message" required>
    <input type="submit" value="Add message">
</form>
<table>
    <tr>
        <td>Task title: ${task.taskTitle}</td>
    </tr>
    <c:if test="${!task.details.isEmpty()}">
        <tr>
            <td>Task details: ${task.details}</td>
        </tr>
    </c:if>
    <c:if test="${task.messages.size() != 0}">
        <tr>
            <td>Task messages:</td>
        </tr>
        <c:forEach items="${task.messages}" var="message">
            <tr>
                <td>
                        ${message}
                </td>
                <td>
                    <a href="/delMessages?message=${message}&taskId=${task.taskId}">
                        <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
