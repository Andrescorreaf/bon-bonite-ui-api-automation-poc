package com.co.starter.tasks.formulario;

import com.co.starter.userinterface.formulariodelquestionario.FormularioDePregutasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OperacionMatematica implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener el texto con la operación matemática (ej: "40*74-235+86-106*255-133-298+157=?")
        String textoOperacionCrudo = Text.of(FormularioDePregutasPage.TEXTO_OPERACION_MATEMATICA)
                .answeredBy(actor)
                .trim();

        System.out.println(">>> TEXTO CRUDO DE LA OPERACIÓN: " + textoOperacionCrudo);

        // Eliminar el signo de igual y caracteres no válidos
        //textoOperacion = textoOperacion.replaceAll("[^0-9+\\-*/.]", "");
        //textoOperacion = textoOperacion.split("=")[0].trim();
        //textoOperacion = textoOperacion.replaceAll("[^0-9+\\-*/()]", ""); // elimina todo lo que no sea número u operador
        // Extraer solo la parte antes del signo igual (si existe)
        if (textoOperacionCrudo.contains("=")) {
            textoOperacionCrudo = textoOperacionCrudo.split("=")[0].trim();
        }

        String textoOperacion = textoOperacionCrudo.replaceAll("[^0-9+\\-*/.]", "");

        System.out.println(">>> EXPRESIÓN EVALUADA: " + textoOperacion);

        // Evaluar la expresión con exp4j
        long resultadoOperacion;
        try {
            Expression expression = new ExpressionBuilder(textoOperacion).build();
            double resultado = expression.evaluate();
            resultadoOperacion = Math.round(resultado);
        } catch (Exception e) {
            throw new RuntimeException("Error al evaluar la operación matemática: " + textoOperacion, e);
        }

        // 🔍 DEBUG: Listar todos los radios en la página
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type='radio']"));
        System.out.println(">>> Radios encontrados:");
        for (WebElement radio : radios) {
            System.out.println(" - value: " + radio.getAttribute("value"));
        }
        System.out.println(">>> VALOR DE LA OPERACIÓN: >>>> " + resultadoOperacion );

        // Validar si el valor calculado está entre los radios
        boolean existeResultado = radios.stream()
                .anyMatch(r -> r.getAttribute("value").equals(String.valueOf(resultadoOperacion)));

        if (!existeResultado) {
            System.out.println(" El resultado calculado (" + resultadoOperacion + ") no está entre las opciones. Se omite clic.");
            return; // para evitar error y continuar el flujo
        }

        // Esperar que el radio correcto sea visible y hacer clic
        actor.attemptsTo(
                WaitUntil.the(FormularioDePregutasPage.TEXTO_OPERACION_MATEMATICA, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        actor.attemptsTo(
                WaitUntil.the(
                        FormularioDePregutasPage.CHECK_RESULTADO_OPERACION_MATEMATICA(String.valueOf(resultadoOperacion)),
                        WebElementStateMatchers.isVisible()
                ).forNoMoreThan(20).seconds(),
                Click.on(FormularioDePregutasPage.CHECK_RESULTADO_OPERACION_MATEMATICA(String.valueOf(resultadoOperacion)))
        );
    }

    public static OperacionMatematica delCalculo() {
        return instrumented(OperacionMatematica.class);
    }
}
