package com.example.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudService {

    @Autowired
    private TransactionRepository repo;

    public TransactionEntity process(Transaction t) {

        double risk = 0;

// weights (like ML model)
risk += (t.getAmount() > 10000) ? 0.4 : 0.1;
risk += ("foreign".equalsIgnoreCase(t.getLocation())) ? 0.3 : 0.1;
risk += ("night".equalsIgnoreCase(t.getTime())) ? 0.2 : 0.1;

// interaction (pattern learning)
if (t.getAmount() > 15000 && "foreign".equalsIgnoreCase(t.getLocation())) {
    risk += 0.2;
}

// normalize
risk = Math.min(risk, 1.0);

boolean fraud = risk > 0.6;
    

    TransactionEntity entity = new TransactionEntity();
    entity.setAmount(t.getAmount());
    entity.setLocation(t.getLocation());
    entity.setTime(t.getTime());
    entity.setRiskScore(risk);
    entity.setFraud(fraud);

    return repo.save(entity);
}
    }