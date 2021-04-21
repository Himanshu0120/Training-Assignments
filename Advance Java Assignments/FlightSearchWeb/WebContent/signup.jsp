<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="form">
        <h1>Sign Up</h1>
        <h3>Enter the following details</h3>
        <%if(session.getAttribute("alert")!=null){ %>
        <h4 style="color: red"><%=session.getAttribute("alert") %></h4>
        <%} %>
        <%session.setAttribute("alert",null); %>
        <form action="signup">
            <div class="input"> <label for="firstname">First Name</label>
                <input type="text" name="firstname" required>
            </div>
                 <div class="input"> <label for="lastname">Last Name</label>
                <input type="text" name="lastname" required>
            </div>
                 <div class="input"> <label for="username">Username</label>
                <input type="text" name="username" required>
            </div>
                <div class="input">
                     <label for="password">Password</label>
                    <input type="password" name="password" required>
                </div>
                <input type="submit" id="signup" value="SignUp">
           
        </form>
        <div class="links">
            
            <a href="index.jsp" id="sign">Login</a>
        </div>
    </div>
</body>
</html>