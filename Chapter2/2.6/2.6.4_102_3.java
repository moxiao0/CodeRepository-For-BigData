model = XGBClassifier(min_chile_weight = 1,max_depth = 10,learning_rate = 0.05,gamma = 0.4,colsample_bytree = 0.4)  #构建XGBoost二分类模型
x_train,x_test,y_train,y_test = train_test_split(train_data,target_data,test_size = 0.3,random_state = 42)  #随机划分训练数据集和测试数据集
model.fit(x_train,y_train)  #训练模型
predict_l = model.predict_proba(x_test)[:,1]  #输出预测结果
auc = roc_auc_score(y_test,predict_l)  #计算AUC
print('AUC is {}'.format(auc))  #输出AUC
