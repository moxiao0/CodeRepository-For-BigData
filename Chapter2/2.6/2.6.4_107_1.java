#输出模型推理结果
output = predict_df.copy()  #获取待预测数据
output['predict_proba'] = model.predict_proba(output)[:, 1]  #使用模型进行预测，得到预测概率
output['predict_label'] = output['predict_proba'].apply(lambda x: 1 if x > 0.3 else 0)  #根据选定的概率阈值划分"羊毛党"
df_output = output[['predict_proba', 'predict_label']].sort_values(ascending=
False, by='predict_proba')  #按照预测概率降序排列疑似"羊毛党"
df_output.to_csv('output.csv')  #保存预测结果
df_output  #输出预测结果
