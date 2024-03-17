public class FileStreamSourceTask extends SourceTask {
    String filename;
    InputStream stream;
    String topic;
    @Override
    //在任务启动时被调用
    //从传入的配置props中读取文件名和主题，打开文件输入流，赋值给相应的成员变量
    public void start(Map<String, String> props) {
        filename = props.get(FileStreamSourceConnector.FILE_CONFIG);
        stream = openOrThrowError(filename);
        topic = props.get(FileStreamSourceConnector.TOPIC_CONFIG);
    }
    @Override
    //这个方法在任务停止时被调用，它负责关闭文件输入流
    public synchronized void stop() {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                // Log error on closing stream
            }
        }
    }
    @Override
    //poll方法是Kafka Connect源任务的核心，用于不断读取数据并生成Kafka消息
    //从文件中逐行读取数据，并将这些数据封装成Kafka Connect的SourceRecord对象
    public List<SourceRecord> poll() throws InterruptedException {
        try {
            ArrayList<SourceRecord> records = new ArrayList<>();
            while (streamValid(stream) && records.isEmpty()) {
                LineAndOffset line = readToNextLine(stream);
                if (line != null) {
                    Map<String, Object> sourcePartition = Collections.singletonMap("filename", filename);
                    Map<String, Object> sourceOffset = Collections.singletonMap("position", line.getOffset());
                    records.add(new SourceRecord(sourcePartition, sourceOffset, topic, Schema.STRING_SCHEMA, line.getLine()));
                    //这行代码创建了一个新的SourceRecord对象，并将其添加到records列表中
                    /**SourceRecord构造函数的参数包括源分区信息、源偏移信息、目标Kafka主题、数据模式(这里使用的是字符串模式)和实际的数据内容(line)**/
                } else {
                    Thread.sleep(100); // Sleep briefly to avoid tight loop if no data
                }
            }
            return records;
        } catch (IOException e) {
            //**如果底层数据流因为调用stop方法而被关闭，poll方法将返回null并且任务的关闭和资源释放将由Kafka Connect框架处理**/
        }
        return null;
    }
}
