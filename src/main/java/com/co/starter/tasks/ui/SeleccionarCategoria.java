package main.java.com.co.starter.tasks.ui;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCategoria implements Task {

    private String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static SeleccionarCategoria porNombre(String categoria) {
        return instrumented(SeleccionarCategoria.class, categoria);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        Target categoriaTarget = Target.the("categoría")
                .locatedBy("//a[contains(text(),'{0}')]")
                .of(categoria);

        actor.attemptsTo(
                Click.on(categoriaTarget)
        );
    }
}