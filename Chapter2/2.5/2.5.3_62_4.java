val inputTSVFile = sc.textFile(path).flatMap(_.split("\t")).collect
inputTSVFile.foreach(println)
