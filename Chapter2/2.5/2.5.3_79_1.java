import collection.mutable.ListBuffer
val rddDatal = sc.parallelize(Array( ("用户1", "接口1"), ("用户2","接口1"), ( "用户1", "接口1"), ( " 用户1", "接口2"), ("用户2", "接口3")) , 2 )
rddDatal.aggregate(ListBuffer[(String)]())((list: ListBuffer[String], tuple:
(String, String)) => list +=tuple._2, (list1: ListBuffer[String] , list2: ListBuffer
[String]) => listl ++= list2)
