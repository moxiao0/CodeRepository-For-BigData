val inputCSVFile = sc.textFile(path).flatMap(_.split(",")).collect
inputCSVFile.foreach(println)
