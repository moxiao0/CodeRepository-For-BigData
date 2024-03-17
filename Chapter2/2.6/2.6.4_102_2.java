train_df.fillna(0,inplace = True)  			#缺失值填充为0
predict_df.fillna(0,inplace = True)  		#缺失值填充为0
target_data = train_df[['phone','label']]  	#导出标签数据
del train_df['label']  						#删除训练数据标签
train_data = train_df
train_data = train_data.set_index('phone')  	#将phone作为DataFrame索引
target_data = target_data.set_index('phone')	#将phone作为DataFrame索引
predict_df = predict_df.set_index('phone')  	#将phone作为DataFrame索引
