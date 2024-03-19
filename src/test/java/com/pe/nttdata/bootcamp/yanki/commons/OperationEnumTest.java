package com.pe.nttdata.bootcamp.yanki.commons;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class OperationEnumTest {

    @Test
    public void shouldValue() {
        assertThat(OperationEnum.OK.value(), is("OK"));
        assertThat(OperationEnum.SEND.value(), is("SEND"));
        assertThat(OperationEnum.ERROR.value(), is("ERROR"));
        assertThat(OperationEnum.RECEIVE.value(),  is("RECEIVE"));
    }


    @Test
    public void shouldGetValue() {
        assertThat(OperationEnum.OK.getValue(), is("OK"));
        assertThat(OperationEnum.SEND.getValue(), is("SEND"));
        assertThat(OperationEnum.ERROR.getValue(), is("ERROR"));
        assertThat(OperationEnum.RECEIVE.getValue(),  is("RECEIVE"));
    }


    @Test
    public void shouldOperationEnum() {
        assertThat(OperationEnum.OK.fromValue("OK").getValue(), is("OK"));
        assertThat(OperationEnum.SEND.fromValue("SEND").getValue(), is("SEND"));
        assertThat(OperationEnum.ERROR.fromValue("ERROR").getValue(), is("ERROR"));
        assertThat(OperationEnum.RECEIVE.fromValue("RECEIVE").getValue(),  is("RECEIVE"));
    }

    @Test
    public void shouldToString() {
        assertThat(OperationEnum.OK.toString(), is("OK"));
        assertThat(OperationEnum.SEND.toString(), is("SEND"));
        assertThat(OperationEnum.ERROR.toString(), is("ERROR"));
        assertThat(OperationEnum.RECEIVE.toString(), is("RECEIVE"));
    }
}

