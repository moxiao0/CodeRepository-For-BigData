//通过前面定义的名字调用select函数来获取对应的流
DataStream<Integer> odd = split.select("odd");

