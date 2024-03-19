package com.pe.nttdata.bootcamp.yanki.util;

import com.pe.nttdata.bootcamp.yanki.model.entity.CurrencyWallet;
import com.pe.nttdata.bootcamp.yanki.model.entity.Customer;
import com.pe.nttdata.bootcamp.yanki.model.entity.Operation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Date;
import static com.pe.nttdata.bootcamp.yanki.commons.OperationEnum.SEND;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class MapperUtilsTest {

    @Test
    public void shouldObjectValue() {

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
        operation.setPaymentType(SEND.value());
        operation.setAmount(100.0);

        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(operation);

        currencyWalle.setCustomer(customer);
        currencyWalle.setOperations(operations);
        currencyWalle.setDescription("");

        assertThat(MapperUtils.mapper(CurrencyWallet.class,currencyWalle).getDescription(),is(""));

    }

    @Test
    public void shouldStringValue() {
        assertThat(MapperUtils.mapper(CurrencyWallet.class,"{ description:'OK' }").getDescription(),is("OK"));
    }

    @Test
    public void shouldWithNullString() {
        String json=null;
        assertNull(MapperUtils.mapper(CurrencyWallet.class,json));
    }

    @Test
    public void shouldWithNullObject() {
        CurrencyWallet currencyWalle=null;
        assertNull(MapperUtils.mapper(CurrencyWallet.class,currencyWalle));
    }

}
