val countsDStream = hashTagsDStream.window(Minutes(10),Seconds(1))
.countByValue()
