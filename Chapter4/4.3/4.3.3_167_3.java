select t1.*, t2.* from
(select * from dept) t1
join
(select * from emp) t2
on 1=1;
