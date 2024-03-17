scala>val peopleDF = spark.read.format("json").load("file:///usr/local/spark/
examples/src/main/resources/people.json") 
scala> peopleDF.select("name", "age").write.format("csv").save("file:///usr/
local/spark/mycode/sql/newpeople.csv")
