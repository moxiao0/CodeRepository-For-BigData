      val 
inputHadoopFile= sc.newAPIHadoopFile[LongWritable,Text,TextInputFormat](path,
classOf[TextInputFormat],classOf[LongWritable],classOf[Text])
      val result = inputHadoopFile.map(_._2.toString).collect
      println(result.mkString("\n"))
