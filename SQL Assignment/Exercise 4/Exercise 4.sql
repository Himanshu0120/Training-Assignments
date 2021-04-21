/*
Exercise 4
Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date,
and returns a table of all the SalesOrderDetail rows for that Sales Order including 
Quantity, ProductID, UnitPrice, and the unit price converted to the target currency
based on the end of day rate for the date provided. Exchange rates can be found in 
the Sales.CurrencyRate table. ( Use AdventureWorks)


*/

CREATE FUNCTION dbo.utf_Orders(@Id int,
							   @CurrencyCode varchar(3)
							   ,@Date date)
RETURNS TABLE
AS
RETURN
	(SELECT
				SOD.OrderQty,
				SOD.ProductID,
				SOD.UnitPrice,
				SOD.UnitPrice * (SELECT CR.EndOfDayRate
								 FROM sales.CurrencyRate CR 
								 WHERE CR.ToCurrencyCode = @CurrencyCode AND CR.CurrencyRateDate = @date
				) AS 'Target Currency Price'
	FROM  Sales.SalesOrderDetail SOD
	WHERE SOD.SalesOrderID = @Id);

