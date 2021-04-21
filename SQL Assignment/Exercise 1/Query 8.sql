SELECT BusinessEntityID AS SALESPERSON_ID,
	   'COMMISSION BAND '=CASE 
	   WHEN CommissionPct=0 THEN 'BAND 0'
	   WHEN CommissionPct>0 AND CommissionPct<=0.01 THEN 'BAND 1'
	   WHEN CommissionPct>0.01 AND CommissionPct<=0.015 THEN 'BAND 2'
	   WHEN CommissionPct>0.015 THEN 'BAND 3'
	   END

FROM Sales.SalesPerson