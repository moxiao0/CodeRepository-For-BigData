val rddDatal = sc.parallelize(1 to 3, 2)
val rddData2 = sc.parallelize(Array("A", "B", "C"), 2)
val rddData3 = rddDatal.zip(rddData2)
rddData3.collect
