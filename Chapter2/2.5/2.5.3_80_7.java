val input = Source.fromFile("D:\\test.txt") //获取文件
.getLines 							//取得文件的每一行
.toArray 							//转化为数组
val wc = sc.parallelize(input) 		//将input结合转化为RDD
.flatMap(_.split(" "))       			//拆分数据，以空格为拆分条件 
.map((_,1))                 			//将拆分的每个数据为键，自己创建的1为值
.reduceByKey(_+_)               		//按key分组汇总
.foreach(println)               		//输出
