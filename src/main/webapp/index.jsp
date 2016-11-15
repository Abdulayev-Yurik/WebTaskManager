<%@ page import="model.Task" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>
<input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'"><br>
<c:forEach items="${taskList}" var="item">

</c:forEach>
</body>
</html>
