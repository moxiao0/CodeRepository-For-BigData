val rddData = sc.parallelize(Array(("201800001", 83), ("201800002",97),
("201800003", 100),("201800004", 95), ("201800005", 87)), 2)
val rddData2 =rddData,mapPartitionsWithIndex((index,iter) =>{
  var result = List[String]()
  while(iter.hasNext){
    result = iter.next() match {
      case (id,grade) if grade >= 95 =>id +"_" + grade +"["+ index + "]" :: result
      case=> result
    }
  }
  result.iterator
})
rddData2.collect

