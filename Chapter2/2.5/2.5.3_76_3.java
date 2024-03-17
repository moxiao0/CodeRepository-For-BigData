val rddDatal = sc.parallelize(Array(("dog", 3), ("cat",1), ("hadoop", 2), ("spark", 3), ("apple", 2)))
val rddData2 = rddDatal•sortBy(_._2, false)
rddData2.collect
