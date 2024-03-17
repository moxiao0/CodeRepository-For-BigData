scala> import org.apache.spark.sql.Row
scala> import org.apache.spark.sql.SparkSession
scala> case class Record(key: Int, value: String)
scala> val warehouseLocation = "spark-warehouse"
scala> val spark = SparkSession.builder().
|  appName("Spark Hive Example").
|  config("spark.sql.warehouse.dir", warehouseLocation).
|  enableHiveSupport().getOrCreate()
scala> import spark.implicits._
scala> import spark.sql
