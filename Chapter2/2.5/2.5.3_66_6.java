def mapPartitions[U: ClassTag](
f: Iterator[T] => Iterator[U],preservesPartitioning: Boolean = false): RDD[U]
