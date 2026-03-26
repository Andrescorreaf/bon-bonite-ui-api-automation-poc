package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SalirDeCuenta implements Task {

    public static SalirDeCuenta aLogout() {
        return instrumented(SalirDeCuenta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            if (SitioDeRegistro.LOGOUT_LINK.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(SitioDeRegistro.LOGOUT_LINK),
                        WaitUntil.the(SitioDeRegistro.NUMERO_CEDULA, isVisible()).forNoMoreThan(10).seconds()
                );
            }
        } catch (Exception e) {
            // Si el elemento no está presente, entonces no hay sesión iniciada y se puede continuar
        }
    }
}
