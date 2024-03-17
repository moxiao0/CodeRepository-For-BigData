DataStream<User> filter = userDataStream.filter(new FilterFunction<User>() {
    public boolean filter(User user) throws Exception {
        return user.getAge() == 20;
    }
});
