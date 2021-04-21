SELECT  TOP 1 ProductID

FROM Production.ProductInventory

ORDER BY dbo.ufnGetStock(ProductID) DESC