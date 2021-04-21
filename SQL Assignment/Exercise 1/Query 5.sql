SELECT Description,
	   ISNULL(MaxQty,0.00) AS 'MaximumQuantity'

FROM Sales.SpecialOffer;