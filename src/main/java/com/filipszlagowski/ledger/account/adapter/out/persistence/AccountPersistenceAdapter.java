package com.filipszlagowski.ledger.account.adapter.out.persistence;

import com.filipszlagowski.ledger.account.application.port.out.SaveAccountPort;
import com.filipszlagowski.ledger.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountPersistenceAdapter implements SaveAccountPort {
    private final AccountRepository accountRepository;
    public AccountPersistenceAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
