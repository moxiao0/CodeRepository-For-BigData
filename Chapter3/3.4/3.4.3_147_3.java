import java.util.Properties;

public class WordCount {
    public static void main(String[] args) throws Exception {
        //获取Flink运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.
getExecutionEnvironment();

        //配置Kafka连接属性
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "zyw-2021148807-0801:9892");
        properties.setProperty("zookeeper.connect", "zyw-2021140807-0801:2181");
        properties.setProperty("group.id", "1");

        //创建Kafka消费者
        FlinkKafkaConsumer08<String> myConsumer = new FlinkKafkaConsumer08<>(
                "test", //Kafka主题
                new SimpleStringSchema(), //序列化Schema
                properties);

        //默认消费策略
        myConsumer.setStartFromGroupOffsets();

        //添加Kafka消费者作为数据源
        DataStream<String> dataStream = env.addSource(myConsumer);

        //数据处理和单词计数
        DataStream<Tuple2<String, Integer>> result = dataStream
                .flatMap(new MyFlatMapper())
                .keyBy(0)
                .sum(1);

        //输出结果
        result.print().setParallelism(1);

        //执行Flink作业
        env.execute("Kafka Flink WordCount");
    }

    public static class MyFlatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            //按空格分词
            String[] words = value.split("\\s+");
            for (String word : words) {
                out.collect(new Tuple2<>(word, 1));
            }
        }
    }
}
