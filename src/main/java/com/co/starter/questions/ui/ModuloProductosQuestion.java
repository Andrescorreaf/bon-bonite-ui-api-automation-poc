package com.co.starter.questions.ui;

import com.co.starter.userinterface.ModuloProductosPage.ModuloProductos;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

public class ModuloProductosQuestion {

    public static Question<Boolean> zapatosVisibles() {
        return actor -> ModuloProductos.LISTADO_ZAPATOS.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> accesoriosVisibles() {
        return actor -> ModuloProductos.LISTADO_ACCESORIOS.resolveFor(actor).isVisible();
    }
}
