scala> val peopleDF = spark.read.format ("json").load("file:///usr/local/spark/examples/src/main/resources/people.json")
scala> peopleDF.rdd.saveAsTextFile("file:///usr/local/spark/mycode/sql/newpeople.txt")
