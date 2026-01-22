package com.filipszlagowski.ledger.account;

import com.filipszlagowski.ledger.account.adapter.out.persistence.AccountRepository;
import com.filipszlagowski.ledger.account.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldDepositMoney() throws Exception {
        // Given
        Account account = new Account(null, new BigDecimal("100.00"), "John Doe");
        account = accountRepository.save(account);

        // When
        mockMvc.perform(post("/accounts/{id}/deposit", account.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "amount": 50.00
                        }
                        """))
                .andExpect(status().isOk());

        // Then
        Account updatedAccount = accountRepository.findById(account.getId()).orElseThrow();
        assertEquals(new BigDecimal("150.00"), updatedAccount.getBalance());
    }
}
