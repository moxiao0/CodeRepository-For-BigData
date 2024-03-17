val rddData = sc.parallelize(data,1)
rddData.saveAsSequenceFile(path,Some(classOf[GzipCodec]))
