val csvRDD = sc.parallelize(Array(array.mkString(",")),1)
csvRDD.saveAsTextFile(path)
