hive> create database if not exists sparktest;  #创建数据库sparktest
hive> show databases;  #查看是否创建了sparktest数据库
#在sparktest数据库中创建一个表student
hive> create table if not exists sparktest.student(
> id int,
> name string,
> gender string,
> age int);
hive> use sparktest; #切换到sparktest数据库
hive> show tables; #显示sparktest数据库下面有哪些表
hive> insert into student values(1, 'Xueqian', 'F', 23);  #插入一条记录
hive> insert into student values(2, 'Weiliang', 'M', 24);  #再插入一条记录
hive> select from student;  #显示表student中的记录
