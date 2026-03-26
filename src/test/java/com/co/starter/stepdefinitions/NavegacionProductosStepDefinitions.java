package com.co.starter.stepdefinitions;

import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import com.co.starter.tasks.ui.NavegarAHome;
import com.co.starter.tasks.ui.NavegarAModuloProductos;
import com.co.starter.tasks.ui.SeleccionarCategoria;
import com.co.starter.questions.ui.ModuloProductosQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class NavegacionProductosStepDefinitions {

    private final Actor actor = OnStage.theActorCalled("Andres Correa");

    @Dado("que el actor está en la página principal")
    public void estaEnPaginaPrincipal() {
        actor.attemptsTo(NavegarAHome.paginaPrincipal());
    }

    @Cuando("navega al módulo de productos")
    public void navegaModuloProductos() {
        actor.attemptsTo(NavegarAModuloProductos.aProductos());
    }

    @Cuando("selecciona la categoría {string}")
    public void seleccionaCategoria(String categoria) {
        actor.attemptsTo(SeleccionarCategoria.categoria(categoria));
    }

    @Entonces("visualiza la lista de zapatos")
    public void visualizaListaZapatos() {
        actor.should(seeThat(ModuloProductosQuestion.zapatosVisibles(), is(true)));
    }

    @Entonces("visualiza la sección de accesorios")
    public void visualizaSeccionAccesorios() {
        actor.should(seeThat(ModuloProductosQuestion.accesoriosVisibles(), is(true)));
    }
}
