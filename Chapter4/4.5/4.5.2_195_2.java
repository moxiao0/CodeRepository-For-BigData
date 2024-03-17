//在滚动窗口上统计求和指标
SELECT id, SUM(var1) FROM Orders GROUP BY TUMBLE(rowtime, INTERVAL '1' DAY), user
//在滑动窗口上统计最小值指标
SELECT id, MIN(var1) FROM Sensors GROUP BY HOP(rowtime, INTERVAL '1' HOUR, INTERVAL '1' DAY), id
//在会话窗口上统计最大值指标
SELECT id, MAX(var1) FROM Sensors GROUP BY SESSION(rowtime, INTERVAL '1' DAY), id
