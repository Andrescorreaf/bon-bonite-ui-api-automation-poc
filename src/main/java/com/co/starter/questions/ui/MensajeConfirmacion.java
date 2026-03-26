package main.java.com.co.starter.questions.ui;


import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static userinterfaces.RegistroPage.*;

public class MensajeConfirmacion {

    public static Question<Boolean> visible() {
        return actor -> MENSAJE_CONFIRMACION.resolveFor(actor).isVisible();
    }

    public static Question<String> texto() {
        return Text.of(MENSAJE_CONFIRMACION);
    }
}