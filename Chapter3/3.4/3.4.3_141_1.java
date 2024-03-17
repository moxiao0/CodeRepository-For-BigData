DataStream<User> userDataStream = env.fromCollection(Arrays.asList(
new User( name: "张明",age: 28,sex:"男")，
new User( name: "李丽",age: 27,sex:"女")，
new User( name: "王刚",age: 25,sex:"男")
));
