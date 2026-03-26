package com.co.starter.tasks.ui;

import com.co.starter.userinterface.ModuloProductosPage.ModuloProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCategoria implements Task {

    private final String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static SeleccionarCategoria categoria(String categoria) {
        return instrumented(SeleccionarCategoria.class, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://www.bon-bonite.com/mi-cuenta/"));
        if ("Zapatos".equalsIgnoreCase(categoria)) {
            actor.attemptsTo(Click.on(ModuloProductos.CATEGORIA_ZAPATOS));
        } else if ("Ropa".equalsIgnoreCase(categoria)) {
            actor.attemptsTo(Click.on(ModuloProductos.CATEGORIA_ROPA));
        } else if ("Accesorios".equalsIgnoreCase(categoria)) {
            actor.attemptsTo(Click.on(ModuloProductos.CATEGORIA_ACCESORIOS));
        } else {
            throw new IllegalArgumentException("Categoría no soportada: " + categoria);
        }
    }
}
