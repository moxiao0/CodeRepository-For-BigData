object FlinkRegisterDataStreamExample {
  def main(args: Array[String]): Unit = {
    //设置流执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tableEnv = StreamTableEnvironment.create(env)
    //创建一个示例数据流
    val inputSteam: DataStream[(Long, String, Int)] = env.fromElements(
      (1L, "temperature", 30),
      (2L, "humidity", 70),
      (3L, "temperature", 35)
    )
    //使用registerDataStream方法注册DataStream为表
    tableEnv.registerDataStream("sensorData", inputSteam, 'id, 'type, 'var1)
    //在sqlQuery()方法中通过表名引用已注册的表
    val resultTable = tableEnv.sqlQuery("SELECT type, SUM(var1) FROM sensorData WHERE type = 'temperature' GROUP BY type")
    //执行并输出结果
    resultTable.toRetractStream[(String, Int)].print()
    env.execute("Flink SQL Reference Registered Table Example")
  }
}
