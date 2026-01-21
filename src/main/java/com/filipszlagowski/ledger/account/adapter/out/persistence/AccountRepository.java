package com.filipszlagowski.ledger.account.adapter.out.persistence;

import com.filipszlagowski.ledger.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
