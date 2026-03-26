package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionUI implements Task {

    private final String cedula;
    private final String contrasena;

    public IniciarSesionUI(String cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena = contrasena;
    }

    public static IniciarSesionUI conCredenciales(String cedula, String contrasena) {
        return instrumented(IniciarSesionUI.class, cedula, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(cedula).into(SitioDeRegistro.NUMERO_CEDULA),
                Enter.theValue(contrasena).into(SitioDeRegistro.CONTRASENA),
                Click.on(SitioDeRegistro.BTN_LOGIN)
        );
    }
}