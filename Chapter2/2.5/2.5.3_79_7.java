val rddDatal = sc.parallelize(Array((" r1", "接口1") , ("用户2","接口1"), ("用户1", "接口1"), ("用户1", "接口2"）, ("用户2", "接口3" ) ) , 2)
rddDatal.foreach(println)
