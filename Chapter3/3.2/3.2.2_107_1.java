public class FileStreamSourceConnector extends SourceConnector {
    private String filename;
    private String topic;
    @Override
    //返回连接器的任务实现类FileStreamSourceTask.class
    //每个Kafka Connect任务负责执行实际的数据传输工作
    public Class<? extends Task> taskClass() {
        return FileStreamSourceTask.class;
    }
    @Override
    //这个方法在连接器启动时被调用
    //它从传入的配置props中读取文件名和主题，并将它们赋值给成员变量
    public void start(Map<String, String> props) {
        filename = props.get(FILE_CONFIG);
        topic = props.get(TOPIC_CONFIG);
    }
    @Override
    //这个方法在连接器停止时被调用
    public void stop() {
        //在这个例子中，没有实现任何特定的停止逻辑，因为连接器不需要执行任何后台监控或清理工作
    }
    @Override
    //这个方法返回一个配置列表，每个配置用于运行一个任务实例
    //本例中只有一个输入流，则只创建了一个配置，将文件名和主题添加到配置中
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        ArrayList<Map<String, String>> configs = new ArrayList<>();
        //只有一个输入流有意义
        Map<String, String> config = new HashMap<>();
        if (filename != null)
            config.put(FILE_CONFIG, filename);
        config.put(TOPIC_CONFIG, topic);
        configs.add(config);
        return configs;
    }
}
