val rddDatal =sc.parallelize(Array(("Alice",  95), ("Tom", 75) ,("Thomas", 88)), 2)
rddDatal.takeOrdered(2)(Ordering.by(t => t._2))
