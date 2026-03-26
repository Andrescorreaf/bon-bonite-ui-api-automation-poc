package main.java.com.co.starter.questions.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Actor;

public class MensajeConfirmacion {

    public static Question<Boolean> visible() {
        return actor -> SitioDeRegistro.TITULO_CUENTA.resolveFor(actor).isVisible();
    }

    public static Question<String> texto() {
        return Text.of(SitioDeRegistro.TITULO_CUENTA);
    }
}
