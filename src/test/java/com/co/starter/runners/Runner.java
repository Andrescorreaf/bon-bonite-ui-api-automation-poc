package com.co.starter.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/usuarios/gestion_usuarios.feature",
        glue = {
                "com.co.starter.stepdefinitions",
                "com.co.starter.hooks"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty"
)
public class Runner {
    // Clase vacía para ejecutar las pruebas
}
