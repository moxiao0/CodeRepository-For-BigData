DataStreamSource<String> source = env.fromElements("张明", "李丽", "王刚");
DataStreamSource<String> source2 = env.fromElements("赵伟", "钱明", "刘铭");
DataStreamSource<String> source3 = env.fromElements("周强", "唐波", "吴勇");

DataStream<String> union = source.union(source2,source3);
DataStream<String> streamOperator = union.map(new MapFunction<String, String>() {
  public String map(String value) throws Exception {
    return value.toUpperCase();
}
});
