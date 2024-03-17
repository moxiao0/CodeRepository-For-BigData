SELECT Education AS education_level,COUNT(Imsi_cnt)AS total_count
FROM label
GROUP BY Education
