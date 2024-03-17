scala> studentDF.registerTempTable("tempTable")
//向Hive中插入记录
scala> sql("insert into sparktest.student select * from tempTable")
