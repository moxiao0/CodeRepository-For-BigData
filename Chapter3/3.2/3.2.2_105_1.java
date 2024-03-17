import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.Collections;
import java.util.Properties;
public class KafkaConsumerExample {
    public static void main(String[] args) {
        //配置Kafka消费者属性
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "kafka-broker1:9092,kafka-broker2:
9092,kafka-broker3:9092"); //Kafka 集群的节点信息
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        properties.put("group.id", "your_consumer_group"); //替换消费组名称

        //创建Kafka消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //订阅Kafka主题
        String topic = "your_topic_name"; //替换Kafka主题名称
        consumer.subscribe(Collections.singletonList(topic));

        //消费并处理Kafka中的数据
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
               //解析JSON数据
                String jsonData = record.value();
                //接收处理基站拉链数据表的数据
                processStationChainData(jsonData);
            }
        }
    }
}
