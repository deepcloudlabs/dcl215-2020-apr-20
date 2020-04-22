package com.example.banking;

import com.example.banking.core.application.CustomerApplicationIncomingPort;
import com.example.banking.core.domain.Currency;
import com.example.banking.core.domain.CurrencyEnum;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.request.TransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BankingRestApiApplication.class)
@AutoConfigureMockMvc
class BankingRestApiApplicationTests {
    @Autowired MockMvc mvc;
    @Autowired ObjectMapper mapper;
    @MockBean
    private CustomerApplicationIncomingPort customerApplication;

    @Test
    void transferBetweenCustomerAccountsThenOk() throws Throwable {
        TransferRequest request = new TransferRequest();
        // test doubles: Mocking -> Mockito
        Mockito.when(customerApplication.transferBetweenAccounts(
                TcKimlikNo.of(request.getIdentity()),
                request.getFromIban(),
                request.getToIban(),
                new Currency(request.getAmount(), CurrencyEnum.TL))).thenReturn(true);
        mvc.perform(
               post("/transfers") // URL
                  .content(mapper.writeValueAsString(request)) // Resource
                  .contentType(MediaType.APPLICATION_JSON) // MIME Type: application/json
         ).andExpect(status().isOk());
    }

}
