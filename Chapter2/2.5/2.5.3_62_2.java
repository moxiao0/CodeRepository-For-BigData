val inputJsonFile = sc.textFile(path)
val content = inputJsonFile.map(JSON.parseFull)
println(content.collect.mkstring("\t"))
