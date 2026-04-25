package com.example.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api")
public class FraudController {

    @Autowired
    private FraudService service;

    @Autowired
    private TransactionRepository repo;

    @PostMapping("/predict")
    @ResponseBody
    public TransactionEntity predict(@RequestBody Transaction t) {
        return service.process(t);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<TransactionEntity> getAll() {
        return repo.findAll();
    }

    // ✅ THIS will now open HTML page
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}