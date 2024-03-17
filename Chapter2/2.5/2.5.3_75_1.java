val rddDatal = sc.parallelize(1 to 10, 2)
val rddData2 = sc.parallelize(20 to 25, 2)
val rddData3 = rddDatal.zipPartitions(rddData2)((rddlterl, rddlter2)=> {    var result = List[(Intf Int)]()    while (rddlterl•hasNext && rddlter2.hasNext){    result ::= (rddlterl•next(), rddlter2•next())    }    result.iterator })
rddData3.collect

