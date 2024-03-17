val rddData = sc.parallelize(List(JSONObject(map1),JSONObject(map2)),1)
rddData.saveAsTextFile(path)
