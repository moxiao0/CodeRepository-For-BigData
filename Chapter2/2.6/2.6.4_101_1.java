import pandas as pd  #用于处理高级数据结构和数据分析
from manas.dataset import mfile  #用于从HDFS上读取数据文件
from sklearn.metrics import roc_auc_score,classification_report #用于评估模型预测结果
from sklearn.model_selection import train_test_split  #用于划分训练数据集和测试数据集
from xgboost import XGBClassifier  #用于构建基于XGBoost算法的分类模型
