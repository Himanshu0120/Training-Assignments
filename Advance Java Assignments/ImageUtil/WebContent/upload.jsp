<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"

    
    
    %>
    <%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="com.training.models.Image" %>
<%@ page import="com.training.hib.HibUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management Utility</title>
<style>
    header{
        text-align: center;
        border-bottom: 1px solid;
    }
   .r{background-color: red}
    table, th, td {
  border: 1px solid black;
}
 .bt{
    border: none;
    padding: 10px 20px 10px 20px;
    background-color: #034488;
    color: #fffcf6;
}

.header{
display:flex;
align-items: center;
    justify-content: space-between;
}

#form-1{
margin-top:30px;
 margin-left: auto;
 margin-right:auto;
 display:none;
}
table{
    margin-top: 100px;
    margin-left: auto;
    margin-right:auto;
}

th{
min-width:100px;
}
</style>
</head>
<body>
<header><h2>Image Management Utility</h2></header>
<div class="header">
<div class="userInput">
    <h3>Upload your image here (max 1mb)</h3>
    <form action="upload" method="post" enctype="multipart/form-data"">
    
    <input type="file" id="img" name="img" accept="image/*">
    <input type="submit" value="submit" class="bt">
    </form>
    <%if(String.valueOf(session.getAttribute("size")).equals("e")){ %>
    <h4>Size should be less than 1mb</h4>
    <%} %>
</div>
<form id="logout" action="LogOut">
<input type="submit" value="LogOut" class="bt">
</form>
</div>

<table>
    <tr>
        <th>S.No</th>
        <th>Name</th>
        <th>Size</th>
        <th>Preview</th>
        <th>Actions</th>
    </tr>
	<%  String username=String.valueOf(session.getAttribute("username"));
    int a=5;
    ArrayList<Image> res=HibUtils.getImages(username);
    int i=1;
    for(Image img:res){
    %>
    <tr>
   <td><%=i++ %></td>
   <td><%=img.getName() %></td>
   <td><%=img.getSize() %> MB</td>
   <td> <img src="<%=img.getPath() %>" ></td>
   <td style="width:200px;display:flex;justify-content: space-between;">
	   <form action="Delete">
	   <input type="hidden" name="id" value=<%=img.getId() %>>
		   <input style="background-color:red" type="submit" value="Delete" id="button-1" class="bt r"/>
	   </form>
	   <button  class="btn bt" id=<%=img.getId() %>>Edit</button>
   </td>
   </tr>
    
   <%} %>
    
    
</table>
<form id="form-1" class="edit" method="get" action="change">
    
<input type="hidden" name="id" class="id">
Enter the new name : <input type="text" name="name">
<input type="submit" value="update">
</form>



<script>
    button=document.querySelectorAll(".btn");
    id=document.querySelector(".id");
    from=document.querySelector(".edit");
   
    button.forEach(btn => {
        btn.addEventListener("click", (e)=>{
            id.value=btn.id;
            console.log(id.value);
            from.style.display = "block";
        })
    });

</script>
</body>
</html> 