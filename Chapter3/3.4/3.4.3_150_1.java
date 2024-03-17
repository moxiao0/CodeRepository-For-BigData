DataSet<Tuple2<Integer,String>> table1 = env.fromCollection(data1);
DataSet<Tuple2<Integer,String>> table2 = env.fromCollection(data2);

//生成笛卡儿积
table1.cross(table2).print();
