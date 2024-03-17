#模型性能指标评估报告函数
def get_threshold_report(y_predict, target_name):
    model_count = y_predict[target_name].value_counts().sort_index()[1]  #获得测试数据集中"羊毛党"的用户数量
    y_test = y_predict[[target_name]]  #单独取出标签列
    model_test = y_predict.copy()
    report = pd.DataFrame()  #初始化report为DataFrame格式
    for i in range(1, 20):  #等间隔选取0.05～0.95的20个不同概率阈值
        sep_pr = []  #记录本次划分结果
        sep_value = i * 0.05  #本次阈值
        col_name = 'sep_.' + str(round(sep_value, 2))  #本次列名，用于记录预测标签
        model_test[col_name] = model_test['predict'].apply(lambda x: 1 if x > sep_value else 0)  #根据预测概率及阈值生成预测标签
        sep_pr.append(str(round(sep_value, 2)))  #记录本次阈值
        sep_pr.append(model_count)  #记录真实"羊毛党"的用户数量
        predict_model = model_test[col_name].value_counts().sort_index()  
#获取预测标签分类统计数量
        if predict_model.shape[0] == 1:  #只有一类标签的情况
            if predict_model.index.format() == '0':  #一类标签为0，即不存在被预测为"羊毛党"的用户
                sep_pr.append(0)  #记录被预测为"羊毛党"的用户数量为0
            else:
                sep_pr.append(predict_model[0])  #一类标签为1，即所有用户均被预测为"羊毛党"，记录被预测为"羊毛党"的用户数量，即predict_model的第一行数据
        else:  #两类标签的情况
            sep_pr.append(predict_model[1])  #记录被预测为"羊毛党"的用户数量，即predict_model的第二行数据
        model_report = classification_report(y_test, model_test[col_name].values, digits=4)  #根据真实标签和预测标签生成分类报告
        pr_str = ' '.join(model_report.split('\n')[3].split()).split(' ')  
#提取分类报告最后一行的三种评估指标
        sep_pr.append(pr_str[1])  	#记录精确率
        sep_pr.append(pr_str[2])  	#记录召回率
        sep_pr.append(pr_str[3])  	#记录F1分数
        report = pd.concat([report, pd.DataFrame([sep_pr])], axis=0)  #拼接本次划分的评估报告
    report.columns = ['threshold', 'actual', 'predict', 'precision', 'recall', 'f1-score']  #设置评估报告列名
    report = report.reset_index(drop=True)  #重置索引，并将原索引删除
    return report  #返回模型性能指标评估报告
