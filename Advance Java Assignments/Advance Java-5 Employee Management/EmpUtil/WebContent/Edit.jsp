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
        *{
            padding: 0%;
            margin: 0%;
        }
        body{
            font-family: "Open Sans", sans-serif;
            background-color: #1f2833;
            color:#e3e2df;
        }
        header{
            height:5vh;
            color: #e3e2df;
            align-items: center;
            display: flex;
            justify-content: space-between;
            padding: 10px;
            background-color: #0b0c10;
        }
        a{
            text-decoration: none;
            color: white;

        }
        .User{
            display: flex;
            align-items: center;
        }
        #logout{
            margin-left: 10px;
            border: none;
            padding: 5px 10px;
            font-size: 16px;
            background-color: #25274d;
        }
input{
    width: 250px;
    height: 30px;
    border-radius: 5px;
    border: none;
}
.input{
    
    display: flex;
    justify-content: space-between;
    width: 500px;
    margin: auto;
    margin-bottom: 20px;
}
form{
    border: solid;
    padding: 20px 0;
    width: 50%;
    margin: auto;
    margin-top: 50px;
    border-radius: 4px;
    text-align: center;
}
.submit{
    width: 150px;
    color: white;

    height: 40px;
    border-radius: 0%;
    text-align: center;
    margin-top: 30px;
    background-color: #25296b;
    cursor: pointer;
}


    </style>
</head>
<body>
    <header>
        <div class="Heading">
            <h2>Employee Management</h2>
        </div>
        <div class="User">
            <h3>Welcome <%=session.getAttribute("username") %></h3>
            <button id="logout"><a href="logout">Logout</a></button>
        </div>
    </header>
    <h3 style="
    text-align: center;margin-top: 30px;">Enter the new details</h3>
    <div class="empinput">
        <form action="upload">
            <div class="input">
            Employee Code : <input type="text" name="empcode" value="<%=request.getParameter("id")  %>"readonly>
        </div>
    <div class="input">
            Employee Name : <input type="text" name="name" required>
        </div>
         <div class="input">Location : <input type="text" name="location" required>
        </div>
        <div class="input">Email : <input type="email" name="email" required>
        </div>
        <div class="input">Date of birth : <input type="date" name="dob" required>
        </div>
        <input type="submit" value="Update" class="submit">
        </form>
         
    </div>
</body>
</html>