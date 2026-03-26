package main.java.com.co.starter.questions.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterfaces.ProductosPage.*;

public class ProductosVisibles implements Question<Boolean> {

    public static ProductosVisibles enPantalla() {
        return new ProductosVisibles();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LISTA_PRODUCTOS.resolveFor(actor).isVisible();
    }
}