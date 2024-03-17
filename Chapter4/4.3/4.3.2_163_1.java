-- 创建外部表
CREATE EXTERNAL TABLE new_external_table LIKE target_table
LOCATION 'hdfs_path_to_store_data';
-- 将数据从现有表复制到外部表
INSERT INTO TABLE new_external_table 
SELECT * FROM target_table;
