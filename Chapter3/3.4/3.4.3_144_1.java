DataStream<String> flatMap = userDataStream.flatMap(new FlatMapFunction<String, String>() {
    public void flatMap(String s，Collector<Strings collector) throws Exception {
    String[] fields = s.split( regex: ",");
    for (string field : fields) {
          collector.collect(field);
    }
}
});
