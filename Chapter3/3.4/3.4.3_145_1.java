DataStreamSource<Integer> streamSource = env.fromElements(1,2,3,4,5,6,7,8);
SplitStream<Integer> split = streamSource.split(new OutputSelector<Integer>() {
    @Override
    public Iterable<String> select(Integer integer) {
        List<String> outPut = new ArrayList<>();
        if (integer % 2 == 0) {
            outPut.add("even"); //如果元素为偶数，就放入一个叫作"even"的流中
        } else {
            outPut.add("odd"); //如果元素为奇数，就放入一个叫作"odd"的流中
        }
        return outPut;
    }
});
