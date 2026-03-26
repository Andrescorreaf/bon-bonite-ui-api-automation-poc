package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarALogin implements Task {

    public static NavegarALogin aLogin() {
        return instrumented(NavegarALogin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.bon-bonite.com/mi-cuenta/"),
                WaitUntil.the(SitioDeRegistro.LINK_LOGIN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SitioDeRegistro.LINK_LOGIN),
                WaitUntil.the(SitioDeRegistro.NUMERO_CEDULA, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}