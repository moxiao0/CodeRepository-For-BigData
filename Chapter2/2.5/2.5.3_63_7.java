val rddData = sc.parallelize(list(("cat",20),("dog",30),("pig",40),("elephant",
10)),1)
rddData.saveAsNewAPIHadoopFile(path,classOf[Text],classOf[IntWritable],classOf[TextOutputFormat[Text,IntWritable]])
