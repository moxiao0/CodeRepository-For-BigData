object SessionWindowExample {
  def main(args: Array[String]): Unit = {
    //设置流执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tableEnv = StreamTableEnvironment.create(env)

    //创建模拟数据流，数据格式为 (时间戳,用户ID,点击次数)
    val dataStream = env.fromElements(
      (System.currentTimeMillis, "user_1", 1),
      (System.currentTimeMillis, "user_2", 1),
      //其他数据
    )

    //将DataStream转换为表，并定义时间属性
    val dataTable = tableEnv.fromDataStream(dataStream, $"eventTime".rowtime, $"userID", $"clicks")

    //注册表
    tableEnv.createTemporaryView("UserClicks", dataTable)

    //使用Flink SQL进行会话窗口聚合查询
    val result = tableEnv.sqlQuery(
      """
        |SELECT
        |  SESSION_START(eventTime, INTERVAL '10' MINUTE) as windowStart,
        |  SESSION_END(eventTime, INTERVAL '10' MINUTE) as windowEnd,
        |  userID,
        |  SUM(clicks) as totalClicks
        |FROM UserClicks
        |GROUP BY SESSION(eventTime, INTERVAL '10' MINUTE), userID
      """.stripMargin)

    //执行查询并输出结果
    result.toRetractStream[(java.sql.Timestamp, java.sql.Timestamp, String, Int)].print()

    //启动流处理程序
    env.execute("Session Window Example")
  }
}
