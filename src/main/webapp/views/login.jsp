<%@page contentType="text/html"%>
<html>
<head>
    <title>Login</title>

    <style>
        body {font-family: Arial; background: #eee;}
        .box {width: 300px; margin: 80px auto; background: white; padding: 20px;}
        input {width: 100%; margin: 10px 0; padding: 10px;}
        button {width: 100%; padding: 10px; background: blue; color: white;}
    </style>
</head>

<body>


<div class="box">

    <h2>Login</h2>
    <% if(request.getAttribute("success") != null) { %>
    <p style="color:green;"><%= request.getAttribute("success") %></p>
    <% } %>

    <p style="color:red;">${error}</p>

    <form action="../user-auth" method="post">

        <input type="hidden" name="action" value="login"/>

        <input type="email" name="email" placeholder="Email" required/>

        <input type="password" name="password" placeholder="Password" required/>

        <button>Login</button>

    </form>

</div>

</body>
</html>