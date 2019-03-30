# stock-market-analysis

MVP of a web application developed in Java and Spring Boot designed to the analysis of the Stock Market.

Performs queries at [Stock Market Trading API](https://stock-market-trading-api.herokuapp.com) and generates the charts in javascript using [amcharts](https://www.amcharts.com/)

For the pages, the project utilizes the facilities of [Thymeleaf](https://www.thymeleaf.org/)

Available for testins at https://stock-market-analysis-vb.herokuapp.com

PS: It will be migrated to a restful application containing a Java api and the frontend developed in React.

# stock-market-trading-api
Available at https://stock-market-trading-api.herokuapp.com

Methods:

`/list`
> Lists a set of stocks of NY

`/info/{symbol}`
> Brings specific data of a stock


`/intraday/{symbol}`
> Brings the intraday history of a stock


`/history/{symbol}`
> Brings the history of a stock in the current year
