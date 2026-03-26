package com.co.starter.stepdefinitions;

import com.co.starter.questions.TituloPruebaExitosa;
import com.co.starter.tasks.ResponderQuestionario;
import com.co.starter.tasks.paginaderegistro.AbrirPaginaDeRePrueba;
import com.co.starter.tasks.paginaderegistro.IngresarAlSitio;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Question.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class ResponderQuestionarioStepDefinitions {

    @Dado("que el usuario esta en la pagina del questionario")
    public void queElUsuarioEstaEnLaPaginaDelQuestionario() {

        OnStage.theActorInTheSpotlight().wasAbleTo(
                AbrirPaginaDeRePrueba.abrir(),
                IngresarAlSitio.delQuestionario());
    }
    @Cuando("el usuario completa el formulario del questionario exitoso")
    public void elUsuarioCompletaElFormularioDelQuestionarioExitoso() {
        OnStage.theActorInTheSpotlight().attemptsTo(ResponderQuestionario.delFormulario());
    }
    @Entonces("debe ser redirigido a una pagina con un hash de exito")
    public void debeSerRedirigidoAUnaPaginaConUnHashDeExito() {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();

        // Espera hasta que la URL contenga '#exito'
        new WebDriverWait(driver, Duration.ofSeconds(80))
                .until(ExpectedConditions.urlContains("#exito"));

        String titulo = TituloPruebaExitosa.es().answeredBy(OnStage.theActorInTheSpotlight());
        System.out.println("Título actual de la página: " + titulo);

        System.setProperty("serenity.keep.driver.open", "true");

    }


}
