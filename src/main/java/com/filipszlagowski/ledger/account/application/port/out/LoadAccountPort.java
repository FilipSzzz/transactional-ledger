package com.filipszlagowski.ledger.account.application.port.out;

import com.filipszlagowski.ledger.account.domain.Account;
import java.util.Optional;

public interface LoadAccountPort {
    Optional<Account> loadAccount(Long accountId);
}
