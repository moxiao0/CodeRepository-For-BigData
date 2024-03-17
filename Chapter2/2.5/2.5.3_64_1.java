val rddData = sc.parallelize(1 to 10)
val rddData2 = rddData.map(_ * 10)
rddData2.collect
