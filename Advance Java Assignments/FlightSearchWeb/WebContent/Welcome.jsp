<%@page import="com.helper.FilesList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
    <h1>Flight Search</h1>
    <div class="form">
        <h3>Enter the following details : </h3>
        <form action="search">
            <div class="input">
                <label for="">Departure Location Code</label>
                <input type="text" name="dep">
            </div>
            <div class="input">
                <label for="">Arrival location code</label>
                <input type="text" name="arr">
            </div>
            <div class="input">
                <label for="">Date of flight</label>
                <input type="date" name="date">
            </div>
           <div class="radio">
            <div class="input">
                <p>Class</p>
                <input type="radio" name="class" value="B">
                <label style="display: inline-block;" for="">B</label>
                <br>
                <input type="radio" name="class" value="E">
                <label  style="display: inline-block;" for="">E</label>
            </div>
            <div class="input">
                <p>Sort result by : </p>
                <input type="radio" name="sort" value="f">
                <label style="display: inline-block;" for="">Sort by fare</label>
                <br>
                <input type="radio" name="sort" value="d">
                <label  style="display: inline-block;" for="">Sort by fare and duration</label>
            </div>
           </div>
            <input type="submit" value="Search" class="submit">
        </form>
    </div>
</body>
</html>