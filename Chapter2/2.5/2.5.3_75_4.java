val rddDatal = sc.parallelize(Array("A", "B", "C", "D", "E"), 2)
val rddData2 = rddDatal.zipWithlndex()
rddData2.collect
