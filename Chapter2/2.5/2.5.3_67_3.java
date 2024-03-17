def mapPartitionsWithlndex[U: ClassTag]( 
f: (Int, Iterator[T]) => Iterator[U], preservesPartitioning: Boolean false): RDD[U]
