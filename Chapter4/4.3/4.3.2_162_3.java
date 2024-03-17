CREATE TABLE bj_employees
AS SELECT name, salary, address	
FROM employees
WHERE se.city = 'BJ';
