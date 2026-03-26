package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarUsuarioUI implements Task {

    public static RegistrarUsuarioUI conDatosValidos() {
        return instrumented(RegistrarUsuarioUI.class);
    }

    public static Task enviar() {
        return Task.where("{0} Bon-bonite registra un nuevo usuario",
                Click.on(SitioDeRegistro.BTN_REGISTRAR)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("123456789").into(SitioDeRegistro.NUMERO_CEDULA),
                Enter.theValue("test@test.com").into(SitioDeRegistro.EMAIL),
                Enter.theValue("password123").into(SitioDeRegistro.CONTRASENA),
                Click.on(SitioDeRegistro.BTN_ACEPTAR_TERMINOS)
        );
    }
}
