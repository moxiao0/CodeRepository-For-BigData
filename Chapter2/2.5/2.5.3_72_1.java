val rddDatal = sc.parallelize(1 to 100, 10)
rddDatal.partitions.length
val rddData2 = rddDatal.coalesce(5)
rddData2.partitions.length
val rddData3 = rddData2.coalesce(7)
rddData3.partitions.length
