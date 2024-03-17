CREATE EXTERNAL TABLE IF NOT EXISTS stocks(
exchange STRING,
symbol		STRING,
ymd			STRING,
price_open	FLOAT,
price_high	FLOAT,
price_low	FLOAT,
price_close	FLOAT,
volume		INT,
price_ad_close FLOAT
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION '/data/stocks';
