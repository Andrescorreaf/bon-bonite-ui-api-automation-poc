package com.co.starter.questions.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Actor;

public class MensajeConfirmacion {

    public static Question<Boolean> visible() {
        return actor -> {
            boolean h3 = SitioDeRegistro.TITULO_CUENTA.resolveFor(actor).isVisible();
            boolean welcome = SitioDeRegistro.MENSAJE_BIENVENIDA.resolveFor(actor).isVisible();
            return h3 || welcome;
        };
    }

    public static Question<String> texto() {
        return Text.of(SitioDeRegistro.MENSAJE_BIENVENIDA);
    }

    public static Question<String> textoCuenta() {
        return Text.of(SitioDeRegistro.TITULO_CUENTA);
    }
}
