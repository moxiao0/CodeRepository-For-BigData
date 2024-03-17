String path = "src/main/java/beans/sale.csv";
DataSource<Sales> salesDataSource = env.readCsvFile(path).ignoreFirstLine()
//基于位置指定对应字段名称
.pojoType(Sales.class,"transactionId","customerId","itemId","amountPaid");
//将DataSource转换成Table
Table table = tableEnvironment.fromDataSet(salesDataSource);
