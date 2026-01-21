package com.filipszlagowski.ledger.account.application.port.out;

import com.filipszlagowski.ledger.account.domain.Account;

public interface SaveAccountPort {
    void save(Account account);
}
