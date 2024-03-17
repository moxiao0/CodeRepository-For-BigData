//创建数据集
DataSet<Tuple3<String, Integer, Integer>> grade = env.fromElements(
    new Tuple3<>("张明", 1000, 10),
    new Tuple3<>("李丽", 1500, 20),
    new Tuple3<>("王刚", 1200, 30),
    new Tuple3<>("周伟", 2000, 10)
);

//按照插入顺序取前3条记录
grade.first(3).print();
