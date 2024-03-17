public class DataSetTest {
    public static void main(String[] args) throws Exception {
        //创建批处理执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //从字符串集合创建数据源
        DataSet<String> text = env.fromElements("Hello Flink", "Hadoop Flink");
        //使用FlatMapFunction对数据集进行处理，并分组求和
        DataSet<Tuple2<String, Integer>> flatMapData = text.flatMap(new MyFlatMapper()).groupBy(0).sum(1);
        //打印结果
        flatMapData.print();
    }
    //自定义FlatMapFunction
    public static class MyFlatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> out) {
            //按空格分词
            String[] words = s.split(" ");
            for (String word : words) {
                out.collect(new Tuple2<>(word, 1));
            }
        }
    }
}
