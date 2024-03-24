//在TableEnvironment中执行Flink SQL
//获取TableEnvironment对象
val tableEnv = TableEnvironment.getTableEnvironment(env)
//这里假设sensors_table是一个已经定义好的Table对象
//这个表的结构是(id, type, timestamp, var1, var2)
tableEnv.registerTable("sensors", sensors_table)
val csvTableSink = new CsvTableSink("/path/csvfile", ...)
//定义字段名称
val fieldNames: Array[String] = Array("id", "type")
//定义字段类型
val fieldTypes: Array[TypeInformation[_]] = Array(Types.LONG, Types.STRING)
//通过registerTableSink将CsvTableSink注册成Table
tableEnv.registerTableSink("csv_output_table", fieldNames,fieldTypes, csvTableSink)
//计算每个传感器ID对应的var1的和，这里假设只计算type为'speed'的传感器
val result: Table = tableEnv.sqlQuery("SELECT id, SUM(var1) AS sumvar1 FROM sensors WHERE type='speed' GROUP BY id")
//通过sqlUpdate方法，将type为 'temperature' 的数据从sensors表中筛选出来
//然后插入csv_output_table
tableEnv.sqlUpdate(
"INSERT INTO csv_output_table SELECT product, amount FROM
Sensors WHERE type = 'temperature'")
