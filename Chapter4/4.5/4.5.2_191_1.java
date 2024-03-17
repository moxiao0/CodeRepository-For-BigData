object TumbleWindowExample {
  def main(args: Array[String]): Unit = {
    //设置流执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tableEnv = StreamTableEnvironment.create(env)

    //创建模拟数据流，数据格式为 (时间戳,用户ID,购买金额)
    val dataStream = env.fromElements(
      (System.currentTimeMillis, "user_1", 100.00),
      (System.currentTimeMillis, "user_2", 150.00),
      //其他数据
    )
//将DataStream转换为表，并定义时间属性
    val dataTable = tableEnv.fromDataStream(dataStream, $"eventTime".rowtime, $"userID", $"amount")

    //注册表
    tableEnv.createTemporaryView("Purchases", dataTable)

    //使用Flink SQL进行滚动窗口聚合查询
    val result = tableEnv.sqlQuery(
      """
        |SELECT
        |  TUMBLE_START(eventTime, INTERVAL '10' MINUTE) as windowStart,
        |  TUMBLE_END(eventTime, INTERVAL '10' MINUTE) as windowEnd,
        |  userID,
        |  SUM(amount) as totalAmount
        |FROM Purchases
        |GROUP BY TUMBLE(eventTime, INTERVAL '10' MINUTE), userID
      """.stripMargin)

    //执行查询并输出结果
    result.toRetractStream[(java.sql.Timestamp, java.sql.Timestamp, String, Double)].print()

    //启动流处理程序
    env.execute("Tumble Window Example")
  }
}

