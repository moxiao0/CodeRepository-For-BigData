-- wugong_education务工人员学历分布
SELECT Education AS education_level, COUNT(Imsi_cnt) AS total_count
FROM label
GROUP BY Education

-- wugong_outflow_Top10务工人员流出地市排行
SELECT lc_city AS flow_out_city, SUM(imsi_cnt) AS total_imsi_cnt
FROM behaviour
GROUP BY lc_city
ORDER BY total_imsi_cnt DESC
LIMIT 10

-- wugong_gender_ratio务工人员男女比例
SELECT gender, COUNT(*) AS count, (COUNT(*) / SUM(COUNT(*)) OVER ()) * 100 AS percentage
FROM information
GROUP BY gender

-- wugong_inflow_Top10务工人员流入地市排行
SELECT juji_city AS city, SUM(Imsi_cnt) AS total_out_count
FROM behaviour
GROUP BY juji_city
ORDER BY total_out_count DESC
LIMIT 10

-- wugong_region务工人员区县分布
SELECT county_name, SUM(imsi_cnt) AS total_count
FROM behaviour
GROUP BY county_name

-- wugong_age务工人员年龄分布
SELECT age, SUM(imsi_cnt) AS total_count
FROM information
GROUP BY age
ORDER BY age

-- wugong_stay_count务工人员驻留人数
SELECT SUM(imsi_cnt) AS total_resident_count
FROM behaviour

-- wugong_stay_time务工人员平均驻留时长
SELECT
    AVG(
        CASE
            WHEN LOCATE('-', stay_time) > 0 THEN
                    (
                            CAST(SUBSTRING_INDEX(stay_time, '-', 1) AS DECIMAL(10, 2)) +
                            CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(stay_time, '-', -1), '小时', 1) AS DECIMAL(10, 2))
                        ) / 2
            ELSE
                CAST(SUBSTRING_INDEX(stay_time, '小时', 1) AS DECIMAL(10, 2))
            END
    ) AS average_stay_time
FROM behaviour

-- wugong_inflow_city务工人员流入地市
SELECT lr_city, SUM(imsi_cnt) AS total_worker_count
FROM behaviour
GROUP BY lr_city

-- wugong_city务工人员地市分布
SELECT city_name, SUM(imsi_cnt) AS Total_Worker
FROM information
GROUP BY city_name
