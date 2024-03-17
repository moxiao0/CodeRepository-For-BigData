hive> create table test
     > (id int, name string,
     > age int, tel string)
     > ROW FORMAT DELIMITED
     > FIELDS TERMINATED BY '\t'
     > STORED AS TEXTFILE;
