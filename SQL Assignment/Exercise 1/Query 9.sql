SELECT Emp.BusinessEntityID
	, per.FirstName
	, per.MiddleName
	, per.LastName
	, Emp.HireDate
	, Emp.JobTitle
	, Emp.OrganizationLevel
	, ph.Rate
	FROM HumanResources.Employee AS Emp
	JOIN HumanResources.EmployeePayHistory AS Ph
	ON Emp.BusinessEntityID=Ph.BusinessEntityID
	JOIN Person.Person AS Per 
	ON Per.BusinessEntityID=Emp.BusinessEntityID
	WHERE Per.BusinessEntityID<49
	ORDER BY Per.BusinessEntityID asc;