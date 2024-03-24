scala> import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
scala> import org.apache.spark.sql.Encoder
scala> import spark.implicits._  
  //导入包，支持把一个RDD隐式转换为一个DataFrame, 下面是系统执行返回的信息
scala> case class Person (name: String, age: Long)    
//定义一个case class 
defined class Person
val peopleDF = spark.sparkContext
  .textFile("file:///usr/local/spark/examples/src/main/resources/people.txt")
  .map(_.split(","))
  .map(attributes => Person(attributes(0), attributes(1).trim.toInt)).toDF()
peopleDF: org.apache.spark.sql.DataFrame = [name: string, age: bigint]

scala> peopleDF.createOrReplaceTempView("people")   
//必须注册为临时表才能供下面的査询使用

scala> val personsRDD = spark.sql("select name, age from people where age > 20") 
//最终生成一个DataFrame, 下面是系统执行后返回的信息
personsRDD: org.apache.spark.sql.DataFrame = [name: string, age: bigint]

scala> personsRDD.map (t => "Name: " + t(0) + "," + "Age: " + t(1)).show()  
//DataFrame中的每个元素都是一行记录
//包含name和age两个字段，分别用t(0)和t(1)来获取值
