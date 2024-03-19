package com.pe.nttdata.bootcamp.yanki.dao;

import com.pe.nttdata.bootcamp.yanki.business.impl.CurrencyWalletImpl;
import com.pe.nttdata.bootcamp.yanki.commons.OperationEnum;
import com.pe.nttdata.bootcamp.yanki.dao.CurrencyWalletDao;
import com.pe.nttdata.bootcamp.yanki.model.entity.Customer;
import com.pe.nttdata.bootcamp.yanki.model.entity.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyWalletControllerTest {

    @InjectMocks
    private CurrencyWalletImpl currencyWalletService;

    @Mock
    private CurrencyWalletDao currencyWalletDao;



    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet currencyWalle = new com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet();
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

        when(currencyWalletDao.findAll()).thenReturn(Flux.just(currencyWalle));
    }

    /*
    @Test
    void create() {


        CurrencyWallet currencyWalle = new CurrencyWallet();
        currencyWalle.setStatus("OK");
        currencyWalle.setCurrencyCoinAmount(1000.0);

        Customer customer = new Customer();
        customer.setIdentityNumber("10520000");
        customer.setEmail("hugo.oliveros@gmail.com");
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

        CurrencyWalletDto currencyWalletDto = new CurrencyWalletDto();
        currencyWalletDto.setCurrencyWallet(currencyWalle);


        System.out.println( currencyWalletService.save(currencyWalletDto.getCurrencyWallet()) );
        System.out.println( currencyWalletDto.getCurrencyWallet() );

      //  when(currencyWalletService.save(currencyWalletDto.getCurrencyWallet())).thenReturn(Mono.just(currencyWalle));

        Mono<CurrencyWallet> result = currencyWalletService.save(currencyWalletDto.getCurrencyWallet());

        StepVerifier.create(result)
                .expectNext(currencyWalle)
                .expectComplete()
                .verify();

        }*/



}
