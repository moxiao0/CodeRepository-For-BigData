hive (default)> set mapreduce.job.reduces=3;
hive (default)> insert overwrite local directory '/opt/module/datas/distribute-
result' select * from emp distribute by deptno sort by empno desc;
