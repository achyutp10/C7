<%@page contentType="text/html"%>
<html>
<head>
    <title>Register</title>

    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
        }

        .box {
            width: 320px;
            margin: 80px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
        }

        input, select {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
            background: green;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background: darkgreen;
        }
    </style>
</head>

<body>


<div class="box">

    <h2>Register</h2>
    <% if(request.getAttribute("success") != null) { %>
    <p style="color:green;"><%= request.getAttribute("success") %></p>
    <% } %>

    <% if(request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="../user-auth" method="post">

        <input type="hidden" name="action" value="register"/>

        <input type="text" name="name" placeholder="Name" required/>

        <input type="email" name="email" placeholder="Email" required/>

        <input type="password" name="password" placeholder="Password" required/>

        <select name="role" required>
            <option value="">Select Role</option>
            <option value="USER">User</option>
            <option value="ADMIN">Admin</option>
        </select>

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>