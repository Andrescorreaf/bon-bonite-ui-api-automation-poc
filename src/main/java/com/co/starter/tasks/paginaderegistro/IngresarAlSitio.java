package com.co.starter.tasks.paginaderegistro;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;

import com.co.starter.userinterface.home.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class IngresarAlSitio implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            SendKeys.of("1080534").into(LoginPage.USUARIO),
            SendKeys.of("10df2f32286b7120Mi00LTQzNTA4MDE=30e0c83e6c29f1c3").into(LoginPage.CONTRASENA),
            Click.on(LoginPage.BOTON_INGRESAR)
            // SendKeys.of("password").into(SitioDeRegistro.CONTRASENA),
            //Click.on(SitioDeRegistro.BTN_ACEPTAR_TERMINOS),
            //Click.on(SitioDeRegistro.BTN_REGISTRAR)
        );
    }

    public static IngresarAlSitio delQuestionario() {
        return new IngresarAlSitio();
    }

    
}
