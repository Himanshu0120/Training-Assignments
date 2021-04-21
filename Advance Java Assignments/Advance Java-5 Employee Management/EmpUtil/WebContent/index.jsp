<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
	background-color: #9f9da7;
	font-size: 1.6rem;
	font-family: "Open Sans", sans-serif;
	color: #2b3e51;
}
h2 {
	font-weight:300;
	text-align:center;
}
p {
	position: relative;
}
a,
a:link,
a:visited,
a:active {
	color:#3ca9e2;
	transition: all 0.2s ease;
	&:focus,
	&:hover {
		color:#329dd5;
		transition: all 0.2s ease;
	}
}
#login-form-wrap {
    
	background-color: #fff;
	width: 35%;
	margin: 100px auto;
	text-align: center;
	padding:20px 0 0 0;
	border-radius: 4px;
	box-shadow: 0px 30px 50px 0px rgba(0, 0, 0, 0.2);
}
#login-form {
	padding:0 60px;
}
input {
	display: block;
	box-sizing: border-box;
	width: 100%;
	outline: none;
	height: 60px;
	line-height: 60px;
	border-radius: 4px;
}
input[type="text"],
input[type="password"]{
	width: 100%;
	padding: 0 0 0 10px;
	margin: 0;
	color: #8a8b8e;
	border: 1px solid #c2c0ca;
	font-style: normal;
	font-size: 16px;
	appearance: none;
	position: relative;
	display: inline-block;
	background: none;
	
}


input[type="submit"] {
	border: none;
	display:block;
	background-color: #3ca9e2;
	color: #fff;
	font-weight: bold;
	text-transform:uppercase;
	cursor: pointer;
	transition: all 0.2s ease;
	font-size: 18px;
	position: relative;
	display: inline-block;
	cursor: pointer;
	text-align: center;
	
}
#signup {
	background-color:#eeedf1;
	color:#8a8b8e;
	font-size:14px;
	width:100%;
	padding:10px 0;
	border-radius: 0 0 4px 4px;
}
    </style>
</head>
<body>
	
    <div id="login-form-wrap">
        <h2>Login</h2>
        <%if(session.getAttribute("alert")!=null){ %>
	<div class="alert" style="text-align: center; color: red;position:relative; font-size: 16px;"><%=session.getAttribute("alert") %></div>
	<%} %>
	<%session.setAttribute("alert",null); %>
        <form id="login-form" action="login">
          <p>
          <input type="text" id="username" name="username" placeholder="Username" required minlength="5" maxlength="50"><i class="validation"><span></span><span></span></i>
          </p>
          <p>
          <input type="password" id="password" name="password" placeholder="Password" required minlength="5" maxlength="50"><i class="validation"><span></span><span></span></i>
          </p>
          <p>
          <input type="submit" id="login" value="Login">
          </p>
        </form>
        <div id="signup">
          <p><a href="signup.jsp">SignUp</a><p>
          </div>
      </div>
</body>
</html>