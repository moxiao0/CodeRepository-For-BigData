DataStream<String> streamOperator = connect.map(new CoMapFunction<String, Integer, String>() {
    public String map1(String s) throws Exception {
        return s + "是字符串类型，直接加扩展名";
    }

    public String map2(Integer Integer) throws Exception {
        return "原本是Int类型:" + integer + "现在也变为String";
    }
});

