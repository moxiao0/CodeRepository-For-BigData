/* 获取文件数据并将其转化为数组*/ 
val input = Source.fromFile("D:\\test.txt")
.getLines
.toArray 
val topk = sc.parallelize(input)	//将input结合转化为RDD
.flatMap(_.split(" "))         	//拆分数据，以空格为拆分条件
.map((_, 1))                    	//将拆分的每个数据为键，自己创建的1为值 
.reduceByKey(_+_)              	//按key分组汇总
.sortBy(_._2,false)          		//根据分组后的第2位数据进行排序
.take(5)                      		//只取前5位 
.foreach(println)              	//输出
