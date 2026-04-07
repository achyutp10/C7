<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>All Topics</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Topic Name</th>
        <th>Created Date</th>
        <th>User ID</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
    </tr>

    <c:if test="${not empty topics}">
        <c:forEach var="t" items="${topics}">
            <tr>
                <td>${t.topic_id}</td>
                <td>${t.topic_name}</td>
                <td>${t.created_at}</td>
                <td>${t.user_id}</td>
                <td>${t.user_name}</td>
                <td>${t.user_email}</td>
                <td>${t.user_role}</td>
            </tr>
        </c:forEach>
    </c:if>

    <c:if test="${empty topics}">
        <tr>
            <td colspan="7">No Topics Found</td>
        </tr>
    </c:if>

</table>