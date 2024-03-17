public class FlinkJoinExample {
    public static void main(String[] args) throws Exception {
        //获取Flink批处理执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //创建第一张表：用户ID和姓名
        ArrayList<Tuple2<Integer, String>> data1 = new ArrayList<>();
        data1.add(new Tuple2<>(1, "张明"));
        data1.add(new Tuple2<>(2, "李丽"));
        data1.add(new Tuple2<>(3, "王刚"));
        data1.add(new Tuple2<>(4, "周伟"));

        //创建第二张表：用户ID和所在城市
        ArrayList<Tuple2<Integer, String>> data2 = new ArrayList<>();
        data2.add(new Tuple2<>(1, "北京"));
        data2.add(new Tuple2<>(2, "上海"));
        data2.add(new Tuple2<>(3, "广州"));
        data2.add(new Tuple2<>(4, "重庆"));

        //将集合转换为DataSet
        DataSet<Tuple2<Integer, String>> table1 = env.fromCollection(data1);
        DataSet<Tuple2<Integer, String>> table2 = env.fromCollection(data2);

        //执行join操作
        table1.join(table2)
                .where(0)
                .equalTo(0)
                .with(new JoinFunction<Tuple2<Integer, String>, Tuple2<Integer, String>, Tuple3<Integer, String, String>>() {
                    public Tuple3<Integer, String, String> join(Tuple2<Integer, String> first, Tuple2<Integer, String> second) {
                        return new Tuple3<>(first.f0, first.f1, second.f1);
                    }
                })
                .print();
    }
}
