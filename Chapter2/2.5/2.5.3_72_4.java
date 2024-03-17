val rddDatal = sc.parallelize(1 to 100, 10)
val rddData2 = rddDatal.repartition(5)
rddData2.partitions.length
val rddData3 = rddData2.repartition(7)
rddData3.partitions.length
