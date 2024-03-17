val rddDatal = sc.parallelize(Array(("语文",95), ("数学",75), ("英语",88)), 2)
rddDatal.count
