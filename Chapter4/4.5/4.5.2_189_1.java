val csvTableSink = new CsvTableSink("/path/csvfile", ...)
//定义字段名称
val fieldNames: Array[String] = Array("id", "type")
//定义字段类型
val fieldTypes: Array[TypeInformation[_]] = Array(Types.LONG,
Types.STRING)
//通过registerTableSink将CsvTableSink注册成Table
tableEnv.registerTableSink("csv_output_table", fieldNames,
fieldTypes, csvSink)
//通过sqlUpdate()方法，将类型为温度的数据筛选出来并输出到外部表中
tableEnv.sqlUpdate(
"INSERT INTO csv_output_table SELECT id, type FROM Sensors WHERE
type = 'temperature'")
