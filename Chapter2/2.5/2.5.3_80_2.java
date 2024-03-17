val rddDatal = sc.parallelize(Array(5, 5, 15, 15), 2)
rddDatal.foreachPartition(iter => { while(iter.hasNext){  val element = iter.next()  println(element) }})
