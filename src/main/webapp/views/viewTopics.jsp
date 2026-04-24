<%@ page import="learninglog.user.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    User u = (User) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("../views/login.jsp");
    }
%>

<% if(session.getAttribute("success") != null) { %>
<p style="color:green;"><%= session.getAttribute("success") %></p>
<% } %>

<% if(session.getAttribute("error") != null) { %>
<p style="color:red;"><%= session.getAttribute("error") %></p>
<% } %>
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
        <th>Image</th>
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
                <td>
                    <img src="${pageContext.request.contextPath}/uploads/${t.topic_image}" width="100" height="100">
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.user.id == t.user_id}">

                            <form action="${pageContext.request.contextPath}/views/updateTopic.jsp" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="${t.topic_id}"/>
                                <input type="hidden" name="name" value="${t.topic_name}"/>
                                <button type="submit">Update</button>
                            </form>

                        </c:when>

                        <c:otherwise>
                            Not Allowed
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.user.id == t.user_id}">

                            <form action="${pageContext.request.contextPath}/deleteTopic" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${t.topic_id}" />
                                <button type="submit" onclick="return confirm('Delete this topic?')">
                                    Delete
                                </button>
                            </form>

                        </c:when>

                        <c:otherwise>
                            Not Allowed
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <a href="${pageContext.request.contextPath}/viewTopicById?id=${t.topic_id}">
                        <button type="button">View By Id</button>
                    </a>
                </td>



            </tr>
        </c:forEach>
    </c:if>

    <c:if test="${empty topics}">
        <tr>
            <td colspan="7">No Topics Found</td>
        </tr>
    </c:if>

</table>