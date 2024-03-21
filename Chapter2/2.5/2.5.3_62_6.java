val rddData = sc.objectFile[Person](path)
println(rddData.collect.toList)
