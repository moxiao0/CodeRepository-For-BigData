val rddData = sc.parallelize((1 to 10),2)
val rddData2 = rddData.mapPartitions(iter=>iter.map(_ * 2))
rddData2.collect
