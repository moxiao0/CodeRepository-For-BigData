val rddDatal = sc.parallelize(1 to 10)
val rddData2 = sc.parallelize(1 to 20)
val rddData3 = rddDatal.union(rddData2)
rddData2.collect
