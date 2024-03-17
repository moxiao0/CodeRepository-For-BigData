val rddData = sc.parallelize(Array(("one",1),("two",2),("three",3)),10)
rddData.saveAsTextFile(path)
