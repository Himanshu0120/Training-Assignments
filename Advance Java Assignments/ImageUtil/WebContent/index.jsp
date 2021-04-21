<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<style>
	body{
	background-color:#72a4e8
	}
.chose{
background-color:#d3dcc8;
color:darkblue

}
   .bt{
    border: none;
    padding: 10px 20px 10px 20px;
    background-color: #034488;
    color: #fffcf6;
}

.login{
	background-color: white;
	padding : 20px 40px 20px 40px;
	background-color:#d3dcc8;
color:darkblue
	
}

.signup{
	background-color: white;
	padding : 20px 40px 20px 40px;
	background-color:#d3dcc8;
color:darkblue
}

</style>
</head>
<body>

<div class="container">
<div class="chose">
<% if(request.getAttribute("message")!=null){ %>
<h3><%=request.getAttribute("message") %></h3>
<%} %>
    <h3>Chose and Option</h3>
    <div class="btns">
        <button id="log" class="bt">Login</button>
    <button id="sign" class="bt">SignUp</button>
    </div>
</div>
<div class="login">
    <form action="Login" method="POST">
        UserName : <input type="text" name="username">
        Password : <input type="text" name="password">
        <input type="submit" value="Login" class="bt"> 
    </form>
</div>
<div class="signup">
    <form action="RegisterUser" method="POST">
        <h4>Enter the following details to register</h4>
        UserName : <input type="text" name="username">
        Password : <input type="text" name="password">
        <input type="submit" value="Register" class="bt">
    </form>
</div>
</div>

</div>
<script src="app.js"></script>
</body>
</html>