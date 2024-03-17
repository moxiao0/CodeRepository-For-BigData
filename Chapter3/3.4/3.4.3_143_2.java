//配置Kafka连接属性
Propertiesproperties = new Properties()
//Properties参数定义
properties.setProperty("bootstrap.servers"，"localhost:9092");
properties.setProperty("zookeeper.connect"，"localhost:2181");
properties.setProperty("group.id","test");
FlinkKafkaConsumer08<String>myconsumer =new FlinkKafkaConsumer08<>(
"topicName", new SimpleStringSchema(), properties); 
//默认消费策略
myconsumer.setStartFromGroupOffsets();
DataStream<String> dataStream = env.addSource(myconsumer);
