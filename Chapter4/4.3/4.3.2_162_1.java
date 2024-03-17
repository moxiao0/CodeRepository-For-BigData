INSERT OVERWRITE TABLE employees
PARTITION (country = 'CN', city = 'BJ')
SELECT * FROM staged_employees se
WHERE se.country = 'CN' AND se.city = 'BJ';
--WHERE子句用于过滤staged_employees表中的数据
--只有country(表示国家的列)等于'CN'并且city(表示城市的列)等于'BJ'的行才会被选中
