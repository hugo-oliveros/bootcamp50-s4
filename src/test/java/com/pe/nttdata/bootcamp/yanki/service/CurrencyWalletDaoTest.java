package com.pe.nttdata.bootcamp.yanki.service;

import com.pe.nttdata.bootcamp.yanki.business.CurrencyWalletBusinessImpl;
import com.pe.nttdata.bootcamp.yanki.commons.OperationEnum;
import com.pe.nttdata.bootcamp.yanki.dto.CurrencyWalletDto;
import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import com.pe.nttdata.bootcamp.yanki.model.entity.Customer;
import com.pe.nttdata.bootcamp.yanki.model.entity.Operation;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.ArrayList;
import java.util.Date;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyWalletDaoTest {

    @InjectMocks
    private CurrencyWalletBusinessImpl currencyWallet;

    @Mock
    private CurrencyWalletService currencyWalletService;

    @BeforeEach
    public void init() {

    }

    @Test
    void findAll() {
        CurrencyWallet currencyWalle = new CurrencyWallet();

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

        when(currencyWalletService.findAll()).thenReturn(Flux.just(currencyWalle));

        Flux<CurrencyWallet> result = currencyWalletService.findAll();

        StepVerifier.create(result)
                .expectNext(currencyWalle)
                .expectComplete()
                .verify();

    }

    @Test
    void create() {


        CurrencyWallet currencyWalle = new CurrencyWallet();
        currencyWalle.setId(new ObjectId("65e781f9d121b02f4b951c25"));
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

        CurrencyWalletDto currencyWalletDto = new CurrencyWalletDto();
        currencyWalletDto.setCurrencyWallet(currencyWalle);

        when(currencyWalletService.save(currencyWalletDto.getCurrencyWallet())).thenReturn(Mono.just(currencyWalle));

        Mono<CurrencyWallet> result = currencyWalletService.save(currencyWalletDto.getCurrencyWallet());

        StepVerifier.create(result)
                .expectNext(currencyWalle)
                .expectComplete()
                .verify();

        }


    @Test
    void delete() {
        final String _id = "65f8c54790c82e1a32b81182";
        when(currencyWalletService.deleteById(_id)).thenReturn(Mono.empty());
        Mono<Void> resul = currencyWalletService.deleteById(_id);
        StepVerifier.create(resul)
                .expectComplete()
                .verify();
    }

}
