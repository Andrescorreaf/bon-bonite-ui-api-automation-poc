package test.java.com.co.starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import tasks.ui.NavegarAHome;
import tasks.ui.SeleccionarCategoria;
import tasks.ui.AccederAPQRS;

import questions.ui.ProductosVisibles;
import questions.ui.FormularioPQRSVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class NavegacionStepDefinitions {

    @Dado("que el usuario se encuentra en la página principal")
    public void usuarioEnHome() {
        actor.attemptsTo(
                NavegarAHome.paginaPrincipal()
        );
    }

    @Cuando("selecciona la categoría {string}")
    public void seleccionarCategoria(String categoria) {
        actor.attemptsTo(
                SeleccionarCategoria.porNombre(categoria)
        );
    }

    @Entonces("el sistema muestra los productos disponibles")
    public void validarProductos() {
        actor.should(
                seeThat("Productos visibles",
                        ProductosVisibles.enPantalla(), is(true))
        );
    }
    
    @Dado("que el usuario se encuentra en el sitio web")
    public void usuarioEnSitio() {
        actor.attemptsTo(
                NavegarAHome.paginaPrincipal()
        );
    }

    @Cuando("accede a la sección de PQRS")
    public void accederPQRS() {
        actor.attemptsTo(
                AccederAPQRS.seccion()
        );
    }

    @Entonces("el sistema muestra el formulario de contacto")
    public void validarFormularioPQRS() {
        actor.should(
                seeThat("Formulario PQRS visible",
                        FormularioPQRSVisible.enPantalla(), is(true))
        );
    }
}