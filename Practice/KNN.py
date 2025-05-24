import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score

# CSV file ka path (replace karo actual path se)
data = pd.read_csv("your_file.csv")

# Features aur label ko alag karo
X = data.iloc[:, :-1]
y = data.iloc[:, -1]

# Train-Test split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3)

# Model create & train
model = KNeighborsClassifier(n_neighbors=3)
model.fit(X_train, y_train)

# Prediction & accuracy
y_pred = model.predict(X_test)
print("Accuracy:", accuracy_score(y_test, y_pred))
