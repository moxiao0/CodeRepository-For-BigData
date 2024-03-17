//从一组元素创建数据流
DataStreamSource<String> personStream = env.fromElements("张明", "李丽");
//将数据转换成CSV文件输出，并设定输出模式为OVERWRITE
personStream.writeAsCsv("file:///path/to/person.csv", FileSystem.WriteMode.
OVERWRITE);
//将数据直接输出到本地文本文件
personStream.writeAsText("file:///path/to/person.txt", FileSystem.WriteMode.
OVERWRITE);
//将DataStream数据集输出到指定Socket端口
personStream.writeToSocket("outputHost", 9999, new SimpleStringSchema());
