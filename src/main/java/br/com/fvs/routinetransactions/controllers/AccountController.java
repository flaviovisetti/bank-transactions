package br.com.fvs.routinetransactions.controllers;

import br.com.fvs.routinetransactions.models.Account;
import br.com.fvs.routinetransactions.repository.AccountRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/accounts/{id}")
    public Optional<Account> findAccount(@PathVariable Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        return account;
    }

    @PostMapping(value = "/accounts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }
}
