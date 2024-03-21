ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//本地流处理执行环境，用于在本地机器上执行流处理作业，通常用于开发和测试
StreamExecutionEnvironment localEnvironment = StreamExecutionEnvironment.
createLocalEnvironment(1); 

//远程流处理执行环境，用于连接到远程Flink集群并在那里执行流处理作业
StreamExecutionEnvironment remoteEnvironment = StreamExecutionEnvironment.
createRemoteEnvironment("hostID", 666, "/home/WordCount.jar");  

