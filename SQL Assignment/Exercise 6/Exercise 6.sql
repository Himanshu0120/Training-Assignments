/*
Write a trigger for the Product table to ensure the list price
can never be raised more than 15 Percent in a single change.
Modify the above trigger to execute its check code only if the
ListPrice column is   updated (Use AdventureWorks Database).
*/

CREATE Or ALTER TRIGGER production.checkListPrice
ON production.product
FOR UPDATE 
AS 
IF EXISTS
(
SELECT 'True'
from inserted i
join deleted d
on i.ProductID=d.ProductID
WHERE (d.ListPrice-i.ListPrice)>=(0.15*i.ListPrice)
)
BEGIN
RAISERROR('List price can not raise more than 15%%',1,1)
ROLLBACK TRAN
END

Update Production.Product 
set ListPrice=Convert(money,100)
where ProductID=1;