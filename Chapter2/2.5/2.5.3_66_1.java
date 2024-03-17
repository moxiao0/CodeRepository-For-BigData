val rddData = sc.parallelize(1 to 100) 
import scala.util.control.Breaks._
val rddData2 = rddData.filter(n => {
  var flag = if (n < 2) false else true
  breakable {
    for (x <- 2 until n) {
      if (n % x == 0) {
        flag = false
        break
      }
    }
  }
  flag
})
rddData2.collect

