$ cd /home/hadoop/spark-2.1.0
$ ./dev/make-distribution.sh --tgz --name h27hive -Pyarn -hadoop-2.7  \
>  -Dhadoop.version=2.7.1 -Phive -Phive-thriftserver -DskipTests
