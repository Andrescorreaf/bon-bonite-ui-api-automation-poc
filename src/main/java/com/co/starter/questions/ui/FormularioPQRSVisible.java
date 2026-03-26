package main.java.com.co.starter.questions.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterfaces.PQRSPage.*;

public class FormularioPQRSVisible implements Question<Boolean> {

    public static FormularioPQRSVisible enPantalla() {
        return new FormularioPQRSVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return FORMULARIO_PQRS.resolveFor(actor).isVisible();
    }
}
