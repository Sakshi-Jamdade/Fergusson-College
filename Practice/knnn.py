import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn.neighbors import KNeighborsClassifier

data=pd.read_csv("File")

print(data.head())
x=data.iloc[:,:-1]
y=data.iloc[:,-1]   

X_train,y_train,x_test,y_test=train_test_split(x,y,test_size=0.3,random_state=42)

model=KNeighborsClassifier(n_neighbors=3)
model.fit(X_train,y_train)

y_pred=model.predict(x_test)
print("Accuracy Matrix : {accuracy_score(y_train,y_pred):.2f")