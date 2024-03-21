WindowedStream<User, String, TimeWindow> timeWindow = userDatastream.keyBy(new KeySelector<User, String>() {
    @Override
    public String getKey(User user) throws Exception {
        return user.getName();
    }
}).timeWindow(Time.seconds(15), Time.seconds(5));

