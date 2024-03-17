String path "src/main/java/beans/sale.csv";
DataSource<Sales> salesDataSource = env.readCsvFile(path).ignoreFirstLine()
                    //基于位置指定对应字段名称
                    .pojoType(Sales.class,"transactionId","customerId","itemId","amountPaid");
//将DataSource转换成Table
Table table = tableEnvironment.fromDataSet(salesDataSource);
salesDataSource.print();
System.out.println("===========================")
Table resultTable = table.groupBy("customerId").select("customerId,sum
(amountPaid)");
DataSet<Row> result = tableEnvironment.toDataSet(resultTable,Row.class);
result.print();
