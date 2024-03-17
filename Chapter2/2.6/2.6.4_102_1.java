train_path = "hdfs://hacluster/user/wutong/example_data/train_data.csv" #训练数据集文件地址
file_r = mfile.mfile(train_path, "r")  #获取文件操作
train_df = pd.read_csv(file_r, sep='\,', header=0) #使用pandas将数据读取成DataFrame，完成后直接使用变量操作文件
file_r.close()  #读取完成后关闭数据流
predict_path = "hdfs://hacluster/user/wutong/example_data/predict_data.csv" #预测数据集文件地址
file_r = mfile.mfile(predict_path, "r")  #获取文件操作
predict_df = pd.read_csv(file_r, sep='\,', header=0) #使用pandas将数据读取成DataFrame，完成后直接使用变量操作文件
file_r.close()  #读取完成后关闭数据流
