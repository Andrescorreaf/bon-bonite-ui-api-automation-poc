package com.co.starter.questions;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;
import com.co.starter.userinterface.formulariodelquestionario.FormularioDePregutasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TituloPruebaExitosa implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return FormularioDePregutasPage.TEXT_CONTEO_CICLOS.resolveFor(actor).getText();
    }
    public static Question<String> es() {
        return new TituloPruebaExitosa();}
}
