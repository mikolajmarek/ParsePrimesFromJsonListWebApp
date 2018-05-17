<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Mikolaj Juras - find primes from JSON package</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
<div class="container mt-4">
    <form action="HomeServlet" method="post">
        <div class="form-group">
            <label for="login">Login:</label><br>
            <input type="text" class="form-control" id="login" placeholder="candidate" name="login">
        </div>
        <div class="form-group">
            <label for="password">Password:</label><br>
            <input type="password" class="form-control" id="password" placeholder="abc123" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Load/Reload</button>
    </form>
</div>

<table class="table table-bordered">
    <tbody>
    <tr>
            <th scope="col" width="300">${listOfPrimes}</th>
    </tr>
    </tbody>

</table>

</body>
</html>
