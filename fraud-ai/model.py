from flask import Flask, request, jsonify
from sklearn.linear_model import LogisticRegression
import numpy as np

app = Flask(__name__)

# Dummy training data
X = np.array([
    [100, 0, 0],
    [20000, 1, 1],
    [5000, 0, 1],
    [15000, 1, 0]
])

y = np.array([0, 1, 0, 1])

model = LogisticRegression()
model.fit(X, y)

@app.route("/predict", methods=["POST"])
def predict():
    data = request.json

    amount = data["amount"]
    location = 1 if data["location"] == "foreign" else 0
    time = 1 if data["time"] == "night" else 0

    input_data = np.array([[amount, location, time]])

    prediction = model.predict(input_data)[0]
    probability = model.predict_proba(input_data)[0][1]

    return jsonify({
        "fraud": int(prediction),
        "risk_score": float(probability)
    })

if __name__ == "__main__":
    app.run(port=5000)