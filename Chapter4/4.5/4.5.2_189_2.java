//查询Sensors表中的全部数据
SELECT * FROM Sensors
//查询Sensors表中的id、type两列数据，并将type列重命名为t
SELECT id, type AS t FROM Sensors
//查询信号类型为temperature的数据
SELECT * FROM Sensors WHERE type = 'temperature'
//查询id为偶数的信号信息
SELECT * FROM Sensors WHERE id % 2 = 0
