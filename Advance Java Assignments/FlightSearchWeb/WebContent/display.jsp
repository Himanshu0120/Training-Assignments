<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.models.Flight"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style3.css">
</head>
<body>
    <h1>Flight Search</h1>
    <h3>Flights matching your inputs</h3>
    <%ArrayList<Flight> result=(ArrayList)request.getAttribute("result");%>
    
    <div class="flights">
    <%for(Flight f:result){ %>
        <div class="flight">
            <div class="info">
                <p>Flight no  :  </p>
            <p><%=f.getFlightNo() %></p>
            </div>
            <div class="info">
                <p>Departure Location  :  </p>
            <p><%=f.getDep_loc() %></p>
            </div>
            <div class="info">
                <p>Arrival Location  :  </p>
            <p><%=f.getArr_loc() %></p>
            </div>
            <div class="info">
                <p>Valid Till  :  </p>
            <p><%=f.getValid_till() %></p>
            </div>
            <div class="info">
                <p>Class  :  </p>
            <p><%= f.getFClass()%></p>
            </div>
            <div class="info">
                <p>Fare  :  </p>
            <p><%=f.getFare() %></p>
            </div>
            <div class="info">
                <p>Duration  :  </p>
            <p><%=f.getDur()%></p>
            </div>
            <div class="info">
                <p>Flight Time  :  </p>
            <p><%=f.getFlight_time() %></p>
            </div>
        
     </div>
     <%} %>   
    </div>
     <div class="button">
        <a href="Welcome.jsp"><button>Search Again</button></a>
    </div>
</body>
</html>