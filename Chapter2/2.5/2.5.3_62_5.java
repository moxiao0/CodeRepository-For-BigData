val inputSequenceFile = sc.sequenceFile[String,String](path)
println(inputSequenceFile.collect.mkString(","))
