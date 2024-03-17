val rddDatal = sc.parallelize(Array(1, 1, 2))
val rddData2 = sc.parallelize(Array(2, 2, 3))
val rddData3 = rddDatal.intersection(rddData2)
rddData3.collect
