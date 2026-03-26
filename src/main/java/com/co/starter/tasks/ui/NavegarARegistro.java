package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarARegistro implements Task {

    public static NavegarARegistro aRegistro() {
        return instrumented(NavegarARegistro.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SitioDeRegistro.LINK_REGISTRATE),
                WaitUntil.the(SitioDeRegistro.TITULO_REGISTRO, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
