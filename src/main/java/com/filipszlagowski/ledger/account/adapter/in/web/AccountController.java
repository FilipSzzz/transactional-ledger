package com.filipszlagowski.ledger.account.adapter.in.web;

import com.filipszlagowski.ledger.account.application.port.in.CreateAccountUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController{
    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }
    @PostMapping
    public void createAccount(@RequestBody CreateAccountRequest request) {
        createAccountUseCase.createAccount(request.name(), request.balance());
    }
}
