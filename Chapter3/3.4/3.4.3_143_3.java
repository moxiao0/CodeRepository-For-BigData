DataStream<User> map = userDataStream.map(new MapFunction<User,User>() {
     public User map(User user) throws Exception {
               return new User(user.getName(),age: user.getAge() + 1,user.getSex());
          }
     });
