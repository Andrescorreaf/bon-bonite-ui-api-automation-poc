package com.co.starter.questions;

import com.co.starter.userinterface.SitioDeRegistroPage.SitioDeRegistro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TituloRegsitro implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SitioDeRegistro.TITULO_CUENTA.resolveFor(actor).getText();
    }

    public static Question<String> es() {
        return new TituloRegsitro();
    }
}