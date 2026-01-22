package com.filipszlagowski.ledger.account.adapter.in.web;

import com.filipszlagowski.ledger.account.application.port.in.CreateAccountUseCase;
import com.filipszlagowski.ledger.account.application.port.in.DepositUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController{
    private final CreateAccountUseCase createAccountUseCase;
    private final DepositUseCase depositUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, DepositUseCase depositUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.depositUseCase = depositUseCase;
    }

    @PostMapping
    public void createAccount(@RequestBody CreateAccountRequest request) {
        createAccountUseCase.createAccount(request.name(), request.balance());
    }

    @PostMapping("/{id}/deposit")
    public void deposit(@PathVariable Long id, @RequestBody DepositRequest request) {
        depositUseCase.deposit(id, request.amount());
    }
}
