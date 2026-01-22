package com.filipszlagowski.ledger.account.application.port.in;

import java.math.BigDecimal;

public interface CreateAccountUseCase {
    Long createAccount(String name, BigDecimal balance);
}
