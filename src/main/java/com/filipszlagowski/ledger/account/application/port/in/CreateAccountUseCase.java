package com.filipszlagowski.ledger.account.application.port.in;

import java.math.BigDecimal;

public interface CreateAccountUseCase {
    public void createAccount(String name, BigDecimal balance);


}
