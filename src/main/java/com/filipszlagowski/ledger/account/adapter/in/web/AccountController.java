package com.filipszlagowski.ledger.account.adapter.in.web;

import com.filipszlagowski.ledger.account.application.port.in.CreateAccountUseCase;
import com.filipszlagowski.ledger.account.application.port.in.DepositUseCase;
import com.filipszlagowski.ledger.account.application.port.in.GetAccountUseCase;
import com.filipszlagowski.ledger.account.application.port.in.WithdrawUseCase;
import com.filipszlagowski.ledger.account.domain.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*") // Zezwól na dostęp z dowolnego źródła (dla łatwiejszego testowania UI)
public class AccountController{
    private final CreateAccountUseCase createAccountUseCase;
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    private final GetAccountUseCase getAccountUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase, GetAccountUseCase getAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
        this.getAccountUseCase = getAccountUseCase;
    }

    @PostMapping
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        Long id = createAccountUseCase.createAccount(request.name(), request.balance());
        return new CreateAccountResponse(id);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id) {
        Account account = getAccountUseCase.getAccount(id);
        return new AccountResponse(account.getId(), account.getName(), account.getBalance());
    }

    @PostMapping("/{id}/deposit")
    public void deposit(@PathVariable Long id, @RequestBody DepositRequest request) {
        depositUseCase.deposit(id, request.amount());
    }

    @PostMapping("/{id}/withdraw")
    public void withdraw(@PathVariable Long id, @RequestBody WithdrawRequest request) {
        withdrawUseCase.withdraw(id, request.amount());
    }
}
