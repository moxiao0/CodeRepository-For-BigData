DataStream<String> flatMap = userDataStream.flatMap(new FlatMapFunction<String, String>() {
    public void flatMap(String s, Collector<String> collector) throws Exception {
        String[] fields = s.split(",");
        for (String field : fields) {
            collector.collect(field);
        }
    }
});

