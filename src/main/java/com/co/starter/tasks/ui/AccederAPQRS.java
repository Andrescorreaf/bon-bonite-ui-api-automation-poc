package main.java.com.co.starter.tasks.ui;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePage.*;

public class AccederAPQRS implements Task {

    public static AccederAPQRS seccion() {
        return instrumented(AccederAPQRS.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_PQRS)
        );
    }
}