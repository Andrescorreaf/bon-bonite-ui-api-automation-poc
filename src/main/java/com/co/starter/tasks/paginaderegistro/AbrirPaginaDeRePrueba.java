package com.co.starter.tasks.paginaderegistro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.co.starter.transversal.PagDeRegistro;
import net.serenitybdd.screenplay.Performable;

public class AbrirPaginaDeRePrueba implements Performable {


    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>>>>< Intentando abiri la pagina");
        actor.attemptsTo(Open.browserOn().the(PagDeRegistro.class));
    }

    public static AbrirPaginaDeRePrueba abrir() {
        return instrumented(AbrirPaginaDeRePrueba.class);
    }
   
}
