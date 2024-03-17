val rddDatal = sc.parallelize(1 to 10, 5)
val rddData2 = rddDatal.glom
rddData2.collect
