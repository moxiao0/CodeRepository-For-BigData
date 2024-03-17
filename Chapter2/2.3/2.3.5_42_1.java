public class WordCount {
 
  public static class Tokenizer Mapper 
       extends  Mapper<Object, Text, Text, IntWritable>{
     
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    // 参数key与value是输入的键值对，参数context可以记录输入的key和value 
    // 参数context还会记录Map运算的状态
    public void  Map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      // 将输入的value进行分词，放入变量itr
      StringTokenizer itr = new StringTokenizer(value.toString());
      // 通过循环语句依次处理itr中的词语
      while (itr.hasMoreTokens()) { 
        word.set(itr.nextToken()); // 获取下一个词语
        context.write(word, one); // 记录当前词语
      }
    }
  }
   
  public static class IntSumReducer 
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();
    // 参数value类似Map函数，不过value是一个迭代器的形式，一个key对应一组的value
    // Reduce也有context，和Map的context作用一样
    public void Reduce(Text key, Iterable<IntWritable> values,Context context
                       ) throws IOException, InterruptedException {
      // 利用循环语句统计value中各个词语的数量，并存放到result中，通过context写入最终结果
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }
 
  public static void main(String[] args) throws Exception {
    // 初始化MapReduce系统配置信息
    Configuration conf = new Configuration();
    // 设置运行时的参数，在错误时给出提示
    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
    if (otherArgs.length != 2) {
      System.err.println("Usage: wordcount <in> <out>");
      System.exit(2);
    }
    // 构建一个Job，第一个参数为conf，第二个参数是这个Job的名字
    Job job = new Job(conf, "word count");
    // 加载所需的各个类
    job.setJarByClass(WordCount.class);
    job.set MapperClass(Tokenizer Mapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    // 定义输出的key和value的类型
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    // 构建输入输出的数据文件，最后一行通过三目运算符设置Job运行成功时程序正常退出
    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
