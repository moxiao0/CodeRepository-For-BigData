$ service mysql start
$ mysql -u root -p  #屏幕上会提示输入密码
#在MySQL Shell环境中，输入以下SQL完成数据库和表的创建
mysql> create database spark;
mysql> use spark;
mysql> create table student (id int(4), name char(20), gender char(4), age int(4));
mysql> insert into student values(1, 'Xueqian', 'F', 23);
mysql> insert into student values(2, 'Weiliang', 'M', 24);
mysql> select from student;
