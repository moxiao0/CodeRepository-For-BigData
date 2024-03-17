val rddData = sc.parallelize(List(person1,person2),1)
rddData.saveAsObjectFile(path)
