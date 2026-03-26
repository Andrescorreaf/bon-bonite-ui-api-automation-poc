package com.co.starter.tasks.ui;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarUsuarioUI implements Task {

    private final String cedula;
    private final String nombres;
    private final String apellidos;
    private final String correo;
    private final String contrasena;
    private final boolean aceptaNewsletter;
    private final boolean aceptaPoliticas;

    public RegistrarUsuarioUI(String cedula, String nombres, String apellidos, String correo, String contrasena, boolean aceptaNewsletter, boolean aceptaPoliticas) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.aceptaNewsletter = aceptaNewsletter;
        this.aceptaPoliticas = aceptaPoliticas;
    }

    public static RegistrarUsuarioUI conDatosIncompletos(String cedula, String nombres, String apellidos, String correo, String contrasena) {
        return new RegistrarUsuarioUI(cedula, nombres, apellidos, correo, contrasena, true, false); // No acepta políticas
    }

    public static RegistrarUsuarioUI conDatos(String cedula, String nombres, String apellidos, String correo, String contrasena, boolean aceptaNewsletter, boolean aceptaPoliticas) {
        return new RegistrarUsuarioUI(cedula, nombres, apellidos, correo, contrasena, aceptaNewsletter, aceptaPoliticas);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(cedula).into(SitioDeRegistro.REG_CEDULA),
                Enter.theValue(nombres).into(SitioDeRegistro.REG_NOMBRES),
                Enter.theValue(apellidos).into(SitioDeRegistro.REG_APELLIDOS),
                Enter.theValue(correo).into(SitioDeRegistro.REG_EMAIL),
                Enter.theValue(contrasena).into(SitioDeRegistro.REG_CONTRASENA),
                Enter.theValue(contrasena).into(SitioDeRegistro.REG_CONFIRMAR_CONTRASENA),
                (aceptaNewsletter ? Click.on(SitioDeRegistro.CHECK_NEWSLETTER) : Task.where("{0} no marca newsletter")),
                (aceptaPoliticas ? Click.on(SitioDeRegistro.CHECK_PRIVACY_POLICY) : Task.where("{0} no marca políticas")),
                Click.on(SitioDeRegistro.BTN_REGISTRAR)
        );
    }
}
