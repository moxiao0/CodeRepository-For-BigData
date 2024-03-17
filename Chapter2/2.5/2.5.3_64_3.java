def flatMap[U: ClassTag](f: T => TraversableOnce[U]): RDD[U]
