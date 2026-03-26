package com.co.starter.tasks.ui;

import com.co.starter.userinterface.ModuloProductosPage.ModuloProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarAModuloProductos implements Task {

    public static NavegarAModuloProductos aProductos() {
        return instrumented(NavegarAModuloProductos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ModuloProductos.LINK_PRODUCTOS),
                WaitUntil.the(ModuloProductos.CATEGORIA_ZAPATOS, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
