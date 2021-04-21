SELECT P.FirstName ,
	   p.LastName 

FROM Person.Person as P INNER JOIN HumanResources.Employee AS H

ON P.BusinessEntityID=H.BusinessEntityID

WHERE JobTitle IN ('Design Engineer','Tool Engineer','Marketing Assistant');