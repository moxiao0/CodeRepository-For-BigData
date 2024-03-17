scala> import spark.implicits._
scala>val df=spark.read.json("file:///usr/local/spark/examples/src/main/
resources/people.json")
scala>df.show()
