<%@ page import="learninglog.user.model.User" %>
<%
    learninglog.user.model.User u = (learninglog.user.model.User) session.getAttribute("user");

    if (u == null || !u.getRole().equals("ADMIN")) {
        response.sendRedirect("../views/login.jsp");
    }
%>

<h1>Welcome Admin: <%= u.getName() %></h1><br>
<form action="../user-auth" method="post">
    <input type="hidden" name="action" value="logout"/>
    <button>Logout</button>
</form>