package com.pe.nttdata.bootcamp.yanki.expose.web;


import com.pe.nttdata.bootcamp.yanki.business.impl.CurrencyWalletBusinessImpl;
import com.pe.nttdata.bootcamp.yanki.commons.OperationEnum;
import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import com.pe.nttdata.bootcamp.yanki.model.entity.Customer;
import com.pe.nttdata.bootcamp.yanki.model.entity.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class CurrencyWalletControllerTest {

    private WebTestClient webTestClient;

    @InjectMocks
    private CurrencyWalletBusinessImpl currencyWalletImpl;



    @BeforeEach
    void setUp() {
      //  webTestClient = WebTestClient.bindToController(currencyWalletImpl).build();
    }

    @Test
    @DisplayName("Return")
    void findAll() {

      /*  CurrencyWallet currencyWalle = new CurrencyWallet();
        currencyWalle.setStatus("OK");
        currencyWalle.setCurrencyCoinAmount(1000.0);

        Customer customer = new Customer();
        customer.setIdentityNumber("10520000");
        customer.setEmail("xxxxx@gmail.com");
        customer.setMobileNumber("9573643");
        customer.setImei("0018273215765765673521");

        Operation operation = new Operation();
        operation.setStatus("OK");
        operation.setTime(new Date());
        operation.setPaymentType(OperationEnum.SEND.value());
        operation.setAmount(100.0);

        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(operation);

        currencyWalle.setCustomer(customer);
        currencyWalle.setOperations(operations);
        currencyWalle.setDescription("");



        webTestClient.get()
                .uri("/currencyWallet/api/v1/all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CurrencyWallet.class)
                .contains(currencyWalle);*/

    }

}
