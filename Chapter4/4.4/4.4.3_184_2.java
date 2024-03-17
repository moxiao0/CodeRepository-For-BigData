scala> import java.util.Properties
scala> import org.apache.spark.sql.types._
scala> import org.apache.spark.sql.Row
//设置两条数据来表示两个学生信息
scala> val studentRDD = spark.sparkContext.
|  parallelize(Array("3 Rongcheng M 26","4 Guanhua M 27")).map(_.split(" "))
//设置模式信息
scala> val schema = StructType(List(StructField("id", IntegerType, true), StructField("name", StringType, true),StructField("gender", StringType, true),StructField("age", IntegerType, true)))
//创建Row对象，每个Row对象都是rowRDD中的一行
scala> val rowRDD = studentRDD.
|  map(p => Row(p(0).toInt, p(1).trim, p(2).trim, p(3).toInt))
//建立Row对象和模式之间的对应关系，也就是把数据和模式对应起来
scala> val studentDF = spark.createDataFrame(rowRDD, schema)
