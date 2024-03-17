val rddDatal = sc.parallelize(1 to 10, 3)
val splitRDD = rddDatal.randomSplit(Array(1, 4, 5))
splitRDD(0).collect
splitRDD(1).collect
splitRDD(2).collect
