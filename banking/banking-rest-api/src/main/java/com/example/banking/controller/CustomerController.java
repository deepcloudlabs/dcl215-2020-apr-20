package com.example.banking.controller;

import com.example.banking.core.application.CustomerApplicationIncomingPort;
import com.example.banking.core.domain.Currency;
import com.example.banking.core.domain.CurrencyEnum;
import com.example.banking.core.domain.TcKimlikNo;
import com.example.banking.request.TransferRequest;
import com.example.banking.response.TransferResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("transfers")
public class CustomerController {
    private CustomerApplicationIncomingPort incomingPort;

    public CustomerController(CustomerApplicationIncomingPort incomingPort) {
        this.incomingPort = incomingPort;
    }

    @PostMapping
    public TransferResponse transfer(@RequestBody TransferRequest request){
        boolean result = incomingPort.transferBetweenAccounts(
                TcKimlikNo.of(request.getIdentity()),
                request.getFromIban(),
                request.getToIban(),
                new Currency(request.getAmount(), CurrencyEnum.TL));
        if (result)
            return new TransferResponse("Ok");
        return new TransferResponse("failed");
    }
}
