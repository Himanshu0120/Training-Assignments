/*

Exercise 2

Write separate queries using a join, a subquery, a CTE, and then an EXISTS to 
list all AdventureWorks customers who have not placed an order.

*/



-- Using join
SELECT c.CustomerID
FROM Sales.Customer AS c LEFT OUTER JOIN 
	 Sales.SalesOrderHeader AS o
	 ON c.CustomerID=O.CustomerID
WHERE o.SalesOrderID IS NULL;


-- Using Subquery
SELECT C.CustomerID
FROM Sales.Customer C
WHERE CustomerID NOT IN (SELECT O.CustomerID
						 FROM Sales.SalesOrderHeader O);


-- USING CTE
WITH CUSTOMERS(CustomerId)
AS(
	SELECT C.CustomerID
	FROM Sales.Customer C
	WHERE CustomerID NOT IN (SELECT O.CustomerID
							FROM Sales.SalesOrderHeader O) 
)

SELECT CustomerId
FROM CUSTOMERS;



--USING EXISTS
SELECT c.CustomerID
FROM Sales.Customer  c
WHERE NOT EXISTS (SELECT o.CustomerID 
FROM Sales.SalesOrderHeader  o
WHERE o.CustomerID=c.CustomerID)