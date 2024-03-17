//左外连接
SELECT * FROM Sensors LEFT JOIN Sensor_detail ON Sensors.id = Sensor_detail.id
//右外连接
SELECT * FROM Sensors RIGHT JOIN Sensor_detail ON Sensors.id = Sensor_detail.id
//全外连接
SELECT * FROM Sensors FULL OUTER JOIN Sensor_detail ON Sensors.id = Sensor_detail.id
