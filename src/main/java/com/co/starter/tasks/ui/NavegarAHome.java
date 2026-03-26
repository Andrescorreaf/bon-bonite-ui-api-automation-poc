package com.co.starter.tasks.ui;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarAHome implements Task {

    public static NavegarAHome paginaPrincipal() {
        return instrumented(NavegarAHome.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("/") // usa baseUrl de serenity.conf
        );
    }
}
