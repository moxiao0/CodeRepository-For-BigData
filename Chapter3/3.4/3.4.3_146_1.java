DataStreamSource<String> source = env.fromElements("张明"","李丽","王刚");
DataStreamSource<Integer> source2 = env.fromElements( data: 1,2,3,4,5,6,7);
ConnectedStreams<String，Integer> connect = source.connect(source2);
