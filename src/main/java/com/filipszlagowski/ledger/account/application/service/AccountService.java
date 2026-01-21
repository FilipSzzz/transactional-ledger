package com.filipszlagowski.ledger.account.application.service;

import com.filipszlagowski.ledger.account.application.port.in.CreateAccountUseCase;
import com.filipszlagowski.ledger.account.application.port.out.SaveAccountPort;
import com.filipszlagowski.ledger.account.domain.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService implements CreateAccountUseCase {
    private final SaveAccountPort saveAccountPort;

    public AccountService(SaveAccountPort saveAccountPort) {
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void createAccount(String name, BigDecimal balance) {
        Account account = new Account(null, balance, name);
        saveAccountPort.save(account);
    }
}
