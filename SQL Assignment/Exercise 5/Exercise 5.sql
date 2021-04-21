/* Exercise 5
		Write a Procedure supplying name information from the Person.
		Person table and accepting a filter for the first name. 
		Alter the above Store Procedure to supply Default Values if 
		user does not enter any value
*/

CREATE or ALTER PROCEDURE Person.FilterName(@Filter varchar(50)=NULL)
AS
BEGIN
	SELECT FirstName
	, LastName 
	FROM Person.Person
	WHERE  FirstName LIKE @Filter OR ISNULL(@Filter,'')=''
END

