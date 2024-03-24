//导入必要的类和包
scala> import org.apache.spark.sql.types._
scala> import org.apache.spark.sql.Row

//创建模式(Schema),模式中包含name和age两个字段
//schema就是"表头"
scala> val fields = Array(StructField("name",StringType,true),StructField("age",IntegerType,true))
scala> val schema = StructType(fields)
 
//下面加载文件生成RDD
scala> val peopleRDD = spark.sparkContext.textFile("file:///usr/local/spark/
examples/src/main/resources/people.txt")

//对peopleRDD这个RDD中的每一行元素都进行解析
scala> val rowRDD = peopleRDD.map(_.split(",")). map(attributes => Row(attributes(0), attributes(1).trim.toInt))
//上面得到的rowRDD就是"表中的记录"
//下面把"表头"和"表中的记录"拼装起来
scala> val peopleDF = spark.createDataFrame(rowRDD, schema)

//必须注册为临时表才能供下面的査询使用
scala> peopleDF.createOrReplaceTempView("people")
scala> val results = spark.sql("SELECT name, age FROM people")
scala> results.map(attributes => "name:" + attributes(0)+ ","+"age:"+
attributes(1)).show()
