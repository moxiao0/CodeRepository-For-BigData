import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        //配置Kafka生产者属性
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "kafka-broker1:9092,kafka-broker2:9092,kafka-broker3:9092"); //Kafka 集群的节点信息
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //创建Kafka生产者
        Producer<String, String> producer = new KafkaProducer<>(properties);
        //生产并发送数据到Kafka主题
        String topic = "your_topic_name"; //替换Kafka主题名称
        //模拟生产数据并发送
        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "message" + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("消息发送成功，偏移量：" + metadata.offset());
                    } else {
                        System.err.println("消息发送失败：" + exception.getMessage());
                    }
                }
            });
        }
        //关闭Kafka生产者
        producer.close();
    }
}
