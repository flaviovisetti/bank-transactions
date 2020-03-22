package br.com.fvs.routinetransactions.controllers;

import br.com.fvs.routinetransactions.models.Transaction;
import br.com.fvs.routinetransactions.repository.TransactionRepository;
import br.com.fvs.routinetransactions.services.TransactionServices;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TransactionController {
    private TransactionRepository repository;
    private TransactionServices services;

    public TransactionController(TransactionRepository repository, TransactionServices services) {
        this.repository = repository;
        this.services = services;
    }

    @PostMapping("/transactions")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody Map<String, Object> payload) {
        Transaction transaction = services.validate(payload);
        repository.save(transaction);
    }
}
