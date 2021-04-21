<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./style.css" />
</head>
<body>
<body>
    <div class="form">
        <h1>Login</h1>
        <%if(session.getAttribute("alert")!=null){ %>
        <h4 style="color: red"><%=session.getAttribute("alert") %></h4>
        <%} %>
        <%session.setAttribute("alert",null); %>
        <form action="login">
            <div class="input"> <label for="username">Username</label>
                <input type="text" name="username" required>
            </div>
                <div class="input">
                     <label for="password">Password</label>
                    <input type="password" name="password" required>
                </div>
                <input type="submit" id="login" value="Login" >
           
        </form>
        <div class="links">
            
            <a href="signup.jsp" id="sign">Sign Up</a>
        </div>
    </div>
</body>
</body>
</html>