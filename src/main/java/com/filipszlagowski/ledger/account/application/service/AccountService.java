package com.filipszlagowski.ledger.account.application.service;

import com.filipszlagowski.ledger.account.application.port.in.CreateAccountUseCase;

import com.filipszlagowski.ledger.account.application.port.in.DepositUseCase;

import com.filipszlagowski.ledger.account.application.port.in.GetAccountUseCase;

import com.filipszlagowski.ledger.account.application.port.in.WithdrawUseCase;

import com.filipszlagowski.ledger.account.application.port.out.LoadAccountPort;

import com.filipszlagowski.ledger.account.application.port.out.SaveAccountPort;

import com.filipszlagowski.ledger.account.domain.Account;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;



import java.math.BigDecimal;

import java.util.NoSuchElementException;



@Service

public class AccountService implements CreateAccountUseCase, DepositUseCase, WithdrawUseCase, GetAccountUseCase {

    private final SaveAccountPort saveAccountPort;

    private final LoadAccountPort loadAccountPort;



    public AccountService(SaveAccountPort saveAccountPort, LoadAccountPort loadAccountPort) {

        this.saveAccountPort = saveAccountPort;

        this.loadAccountPort = loadAccountPort;

    }



    @Override

    public Long createAccount(String name, BigDecimal balance) {

        Account account = new Account(null, balance, name);

        Account savedAccount = saveAccountPort.save(account);

        return savedAccount.getId();

    }



    @Override

    public Account getAccount(Long id) {

        return loadAccountPort.loadAccount(id)

                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + id));

    }



    @Override

    @Transactional

    public void deposit(Long accountId, BigDecimal amount) {

        Account account = loadAccountPort.loadAccountLocked(accountId)

                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + accountId));


        account.deposit(amount);

        saveAccountPort.save(account);

    }


    @Override

    @Transactional

    public void withdraw(Long accountId, BigDecimal amount) {

        Account account = loadAccountPort.loadAccountLocked(accountId)

                .orElseThrow(() -> new NoSuchElementException("Account not found with id: " + accountId));


        account.withdraw(amount);

        saveAccountPort.save(account);

    }

}
