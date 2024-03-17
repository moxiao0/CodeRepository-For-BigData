val tsvRDD = sc.parallelize(Array(array.mkString("\t")),1)
tsvRDD.saveAsTextFile(path)
