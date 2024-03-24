object FlinkTableSqlExample {
  def main(args: Array[String]): Unit = {
    //设置流执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tableEnv = StreamTableEnvironment.create(env)

    //创建一个示例数据流
    val inputStream: DataStream[(Long, String, Int)] = env.fromElements(
      (1L, "temperature", 30),
      (2L, "humidity", 70),
      (3L, "temperature", 35)
    )

    //将DataStream转换成Table
    val sensorTable = tableEnv.fromDataStream(inputStream, $"id", $"type", $"var1")

    //直接在SqlQuery方法中使用$符号引用Table对象
    val resultTable = tableEnv.sqlQuery(s"SELECT type, SUM(var1) FROM $sensorTable WHERE type = 'temperature' GROUP BY type")

    //执行并打印结果
    resultTable.toRetractStream[(String, Int)].print()

    env.execute("Flink Table API and SQL Integration Example")
  }
}
