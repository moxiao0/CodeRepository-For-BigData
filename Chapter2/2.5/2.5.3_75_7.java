val rddDatal = sc•parallelize(Array("A", "B", "C", "D", "E"), 2)
val rddData2 = rddDatal•zipWithUniqueld()
rddData2.collect
