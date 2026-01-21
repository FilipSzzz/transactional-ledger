package com.filipszlagowski.ledger.account.application.port.in;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(Long accountId, BigDecimal amount);
}
