

-- Show the most recent five orders that were purchased from account numbers 
-- that have spent more than $70,000 with AdventureWorks.


select TOP 5 *

from Sales.SalesOrderHeader

where CustomerID in (select CustomerID
					from AdventureWorks.Sales.SalesOrderHeader
					group by CustomerID
					having SUM(TotalDue)>70000)

order by OrderDate desc;
