Select AVG(AverageRate*EndOfDayRate) as 'Overall'

FROM Sales.CurrencyRate

WHERE FromCurrencyCode='USD' AND ToCurrencyCode='GBP' AND YEAR(CurrencyRateDate)=2005;