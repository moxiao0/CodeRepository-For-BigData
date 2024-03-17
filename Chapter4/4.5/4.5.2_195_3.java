//通过Over关键字直接定义Over Window，并统计var1的最大值
SELECT MAX(var1) OVER (
//根据id进行聚合
PARTITION BY id
//根据Proctime进行排序
ORDER BY proctime
//ROWS数据范围为从当前数据向前推10条记录
ROWS BETWEEN 10 PRECEDING AND CURRENT ROW) FROM Sensors
//通过Over关键字定义OVER WINDOW，通过OVER关键字引用定义好的window
SELECT COUNT(var1) OVER window, SUM(var1) OVER window FROM Sensors
//定义WINDOW并重命名为window
WINDOW window AS ( PARTITION BY id ORDER BY proctime ROWS BETWEEN 10 PRECEDING AND CURRENT ROW)
