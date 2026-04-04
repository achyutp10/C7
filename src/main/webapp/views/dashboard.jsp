<%@ page import="learninglog.user.model.User" %>
<%
    learninglog.user.model.User u = (learninglog.user.model.User) session.getAttribute("user");

    if (u == null) {
        response.sendRedirect("../views/login.jsp");
    }
%>


<h1>Welcome User: <%= u.getName() %></h1><br>
<form action="../user-auth" method="post">
    <input type="hidden" name="action" value="logout"/>
    <button>Logout</button>
</form>

<% if(session.getAttribute("success") != null) { %>
<p style="color:green;"><%= session.getAttribute("success") %></p>
<% } %>

<% if(session.getAttribute("error") != null) { %>
<p style="color:red;"><%= session.getAttribute("error") %></p>
<% } %>


<form action="../addTopic" method="post">
    <input type="text" name="name" placeholder="New Topic" required/>
    <button>Add</button>
</form>
