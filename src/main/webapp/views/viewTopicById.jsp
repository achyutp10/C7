<%@ page import="learninglog.topic.model.dto.TopicDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    TopicDTO topic = (TopicDTO) request.getAttribute("topic");
%>

<html>
<head>
    <title>View Topic</title>
</head>
<body>

<h2>Topic Details</h2>

<% if (topic != null) { %>
<p><strong>ID:</strong> <%= topic.getTopic_id() %></p>
<p><strong>Name:</strong> <%= topic.getTopic_name() %></p>
<p><strong>User Name:</strong> <%= topic.getUser_name() %></p>
<p><strong>Email:</strong> <%= topic.getUser_email() %></p>
<p><strong>Role:</strong> <%= topic.getUser_role() %></p>
<p><strong>Created At:</strong> <%= topic.getCreated_at() %></p>
<% } else { %>
<p>Topic not found.</p>
<% } %>

</body>
</html>