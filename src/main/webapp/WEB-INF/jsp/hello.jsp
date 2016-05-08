<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>

<div>
    <p>
        <%--@elvariable id="actors" type="java.util.List<biz.tugay.saqila.model.Actor>"--%>
        <c:forEach items="${actors}" var="actor">
            <c:out value="${actor.first_name}"/> &nbsp; <c:out value="${actor.last_name}" />
            <br />
        </c:forEach>
    </p>
</div>
</body>
</html>