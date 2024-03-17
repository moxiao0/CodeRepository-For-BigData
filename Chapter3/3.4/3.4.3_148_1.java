public class FlinkDistinctWords {
    public static void main(String[] args) throws Exception {
        //获取Flink批处理执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //创建数据集
        ArrayList<String> data = new ArrayList<>();
        data.add("I love Beijing");
        data.add("I love China");
        data.add("Beijing is the capital of China");
        //从集合创建数据源
        DataSource<String> text = env.fromCollection(data);
        //使用FlatMap函数处理数据并将其分割为单词
        DataSet<String> flatMapData = text.flatMap(new FlatMapFunction<String, String>() {
            public void flatMap(String value, Collector<String> out) throws Exception {
                String[] words = value.split("\\s+");
                for (String word : words) {
                    out.collect(word);
                }
            }
        });
        //去除重复的单词并输出结果
        flatMapData.distinct().print();
    }
}
