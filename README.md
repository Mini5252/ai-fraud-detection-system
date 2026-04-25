# AI Fraud Detection System

## 🚀 Overview
A Spring Boot based backend system that detects fraudulent transactions using rule-based risk scoring.

## 🛠 Tech Stack
- Java (Spring Boot)
- MySQL
- REST APIs
- HTML Dashboard

## ⚙️ Features
- Predict fraud based on transaction data
- Risk score calculation
- Store transactions in database
- Dashboard to visualize transactions

## 🔗 API Endpoints
- POST /api/predict → Detect fraud
- GET /api/all → Fetch all transactions
- GET /api/dashboard → View dashboard

## 📊 Sample Input
{
  "amount": 20000,
  "location": "foreign",
  "time": "night"
}

## 🎯 Output
{
  "riskScore": 1.3,
  "fraud": true
}
