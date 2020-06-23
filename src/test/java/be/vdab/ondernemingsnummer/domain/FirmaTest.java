package be.vdab.ondernemingsnummer.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FirmaTest {
    private Validator validator;
    private Firma firma;

    @BeforeEach
    void beforeEach(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        firma = new Firma();
        firma.setOndernemingsNummer(426388541);
    }

    @Test
    void correctNummer() {
        assertThat(validator.validate(firma)).isEmpty();
    }

    @Test
    void verkeerdeNummer() {
        firma.setOndernemingsNummer(426388540);
        assertThat(validator.validate(firma)).isNotEmpty();
    }
}