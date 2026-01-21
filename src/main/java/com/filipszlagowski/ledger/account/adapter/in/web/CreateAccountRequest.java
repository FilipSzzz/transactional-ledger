package com.filipszlagowski.ledger.account.adapter.in.web;

import java.math.BigDecimal;

public record CreateAccountRequest(String name, BigDecimal balance) {

}
