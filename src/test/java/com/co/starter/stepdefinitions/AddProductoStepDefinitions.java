package com.co.starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class AddProductoStepDefinitions {
    
    // Step definitions for adding a product will go here

    @Dado("que estoy en la página de inicio")
    public void queEstoyEnLaPaginaDeInicio() {
        // Code to navigate to the product page
    }

    @Cuando("el usuario agrega un producto al carrito")
    public void elUsuarioAgregaUnProductoAlCarrito() {
        // Code to add a product to the cart
    }

    @Entonces("el producto debe ser agregado exitosamente")
    public void elProductoDebeSerAgregadoExitosamente() {
        // Code to verify the product was added
    }

}
