import numpy as np
from flask import Flask, request, jsonify, render_template
import pickle
import os
import pandas as pd
import numpy as np

#app name

def determine(x):
  if x > 0.781: return 5
  elif x > 0.68: return 4
  elif x > 0.63: return 3
  elif x > 0.55: return 2
  else: return 1


app = Flask(__name__) 
#load the saved model
host_addr = "0.0.0.0"
port_num = "8080"

def load_model(): 
    return pickle.load(open('lgb.pkl', 'rb')) #home
@app.route('/')
def home():
    return render_template('index.html')
@app.route('/predict',methods=['POST'])
def predict():
# '' For rendering results on HTML GUI ''
    labels = ['평균기온(℃)', '최저기온(℃)', '최고기온(℃)','전기사용량','강수량','습도']
    features = [float(x)  for x in request.form.values()]

    values = [np.array(features)]
    model = load_model() 
    prediction = model.predict(values, predict_disable_shape_check=True) 
    #확률값을 라벨값으로
    result = pd.Series(prediction).apply(determine) 
    # return render_template('index.html', output='The Flower is {}'.format(result))
    print(result.get(0))
    return str(result.get(0))

if __name__ == "__main__":
    # port=int(os.environ.get('PORT',5000))
    app.run(host=host_addr, port=port,debug=True,use_reloader=False)