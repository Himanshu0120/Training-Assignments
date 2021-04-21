SELECT  ROW_NUMBER() OVER(ORDER BY FirstName) As 'ROW_NUMBER',
	   FirstName ,
	   LastName

FROM Person.Person

WHERE FirstName LIKE '%SS%';