import pandas as pd
#드라이브에 접근할 수 있도록 아래 코드 입력
# from google.colab import drive
#drive.mount('/content/drive/', force_remount=True)
#불러올 파일의 경로를 filename 변수에 저장
from lightgbm import LGBMClassifier

import joblib

import pandas as pd
import numpy as np
import lightgbm as lgb

from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import mean_squared_error,roc_auc_score,precision_score

# from bento_service import LGBMClassifier
import bentoml
# from bentoml import artifacts, api, BentoService
#pandas read_csv로 불러오기
#data = pd.read_csv(filename,  encoding='latin_1' ,engine='python')
#data.head()

# xl_file = pd.ExcelFile(file_name)
df = pd.DataFrame()
# for i in range(1,10):
# for sheet_name in xl_file.:

def determine(x):
  if x > 0.781: return 5
  elif x > 0.68: return 4
  elif x > 0.63: return 3
  elif x > 0.55: return 2
  else: return 1

params = {}
params['learning_rate'] = 0.003
params['boosting_type'] = 'gbdt'
params['objective'] = 'binary'
params['metric'] = 'binary_logloss'
params['sub_feature'] = 0.5
params['num_leaves'] = 10
params['min_data'] = 50
params['max_depth'] = 10

for i in range(1,11):
  file_name = '../' + str(i)+ '.csv'
  xl_file = pd.read_csv(file_name,encoding='euc-kr')
  # print(dfs.shapes)
  # test_result = pd.DataFrame.from_records([test_row])
  # X = pd.DataFrame(xl_file['Sheet1'])
  X = pd.DataFrame(xl_file)
  X = X.drop(labels = '날짜', axis = 1)
  df = pd.concat([df,X],axis = 0)
file = df

for i in range(1,10):
  df = pd.concat([df,df],axis = 0)
file = df
print(file.shape)

x_features = file.iloc[:,:-2]
y_labels = file.iloc[:, -1]
print(x_features.shape, y_labels.shape)
# # 전처리 -------------------------------------------------------
X_train,X_test,y_train,y_test=train_test_split(x_features,y_labels,test_size=0.3,random_state=0)
X_test, X_val, y_test, y_val = train_test_split(X_test, y_test, test_size=0.5, random_state=42)

# create dataset for lightgbm
lgb_train = lgb.Dataset(X_train, y_train)
lgb_eval = lgb.Dataset(X_test, y_test, reference=lgb_train)

# train
# gbm = lgb.train(
#    params, lgb_train, num_boost_round=20, valid_sets=lgb_eval
# )

# # `save` a given classifier and retrieve coresponding tag:
# model = bentoml.lightgbm.save_model("lightgbm", gbm)
# # retrieve metadata with `bentoml.models.get`:
# bento_model = bentoml.models.get("lightgbm:latest")

# # `load` the model back in memory:
# loaded_model = bentoml.lightgbm.load_model("lightgbm:latest")
# # bentoml.LgbModelService(loaded_model)
# # Run a given model under `Runner` abstraction with `to_runner`
# # input_data = pd.from_csv("/path/to/csv")
# runner = bentoml.lightgbm.get("lightgbm:latest").to_runner()

# runner.init_local()

# file_name = '../1.csv'
# xl_file = pd.read_csv(file_name,encoding='euc-kr')
# X = pd.DataFrame(xl_file)
# input_data = X.drop(labels = '날짜', axis = 1)



# input_data=[[22.3,20,24.9,0.1,38.5,88,4]]

# runner.run(input_data)

# --------------------------------------------------------------------------------------------



sc = StandardScaler()
sc.fit(X_train)
x_train = sc.fit_transform(X_train)
x_test = sc.transform(X_test)
x_test = sc.transform(X_test)
# # 전처리 -------------------------------------------------------
d_train = lgb.Dataset(x_train, label=y_train)
clf = lgb.Dataset(X_train, label=y_train.values)
tra = lgb.train(params, d_train,num_boost_round = 100)

joblib.dump(tra, 'lgb.pkl')

#prediction on the test set
print(X_val.shape)
y_pred=tra.predict(X_val)

# lgb_clf = lgb.LGBMClassifier(num_leaves=31, objective='binary')
# lgb_clf.fit(X_train, y_train)


#예측
# y_pred_val = tra.predict(X_val)

#확률값을 라벨값으로
y_pred_val = pd.Series(y_pred).apply(determine) 
print("-------------------------------------------------------------")
print(y_pred_val.value_counts()/y_pred_val.count())
print(y_pred_val)

# # save model
