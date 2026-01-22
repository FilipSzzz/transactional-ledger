package com.filipszlagowski.ledger.account.adapter.out.persistence;

import com.filipszlagowski.ledger.account.application.port.out.LoadAccountPort;
import com.filipszlagowski.ledger.account.application.port.out.SaveAccountPort;
import com.filipszlagowski.ledger.account.domain.Account;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountPersistenceAdapter implements SaveAccountPort, LoadAccountPort {
    private final AccountRepository accountRepository;
    public AccountPersistenceAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Optional<Account> loadAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
