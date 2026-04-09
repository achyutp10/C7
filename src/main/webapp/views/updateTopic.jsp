<%
  String id = request.getParameter("id");
  String name = request.getParameter("name");
%>

<h2>Update Topic</h2>

<form action="../updateTopic" method="post">

  <input type="hidden" name="id" value="<%= id %>" />

  <input type="text" name="name" value="<%= name %>" required />

  <button type="submit">Update</button>

</form>