val rddData = sc.parallelize(Array("Alice","Nick","Alice","Kotlin", "Catalina"," Catalina "), 3)
val rddData2 = rddData.distinct 
rddData2.collect
