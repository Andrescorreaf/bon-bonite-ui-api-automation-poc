package com.co.starter.tasks.formulario;

import com.co.starter.userinterface.formulariodelquestionario.FormularioDePregutasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OperacionFecha implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener el texto que contiene días y fecha
        String texto = Text.of(FormularioDePregutasPage.TEXTO_DE_LA_FECHA)
                .answeredBy(actor)
                .trim();

        System.out.println("Texto capturado: " + texto);

        // Buscar número de días en el texto
        Pattern diasPattern = Pattern.compile("(\\d+)\\s+(?:días|days)");
        Matcher diasMatcher = diasPattern.matcher(texto);
        int dias = 0;
        if (diasMatcher.find()) {
            dias = Integer.parseInt(diasMatcher.group(1));
        } else {
            throw new RuntimeException("No se encontró el número de días en el texto: " + texto);
        }

        // Buscar fecha en formato dd/MM/yyyy
        Pattern fechaPattern = Pattern.compile("(\\d{2}/\\d{2}/\\d{4})");
        Matcher fechaMatcher = fechaPattern.matcher(texto);
        String fechaTexto = null;
        if (fechaMatcher.find()) {
            fechaTexto = fechaMatcher.group(1);
        } else {
            throw new RuntimeException("No se encontró la fecha en el texto: " + texto);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaBase = LocalDate.parse(fechaTexto, formatter);

        // Detectar si se deben restar los días (antes de) o sumar (después de)
        boolean esAntes = texto.toLowerCase().contains("before") || texto.toLowerCase().contains("antes");

        LocalDate fechaResultado = esAntes
                ? fechaBase.minusDays(dias)
                : fechaBase.plusDays(dias);

        System.out.println("Fecha base: " + fechaBase);
        System.out.println("Días: " + dias);
        System.out.println("Operación: " + (esAntes ? "Resta" : "Suma"));
        System.out.println("Resultado: " + fechaResultado);

        // Enviar la fecha en formato MMddyyyy
        String fechaParaInput = fechaResultado.format(DateTimeFormatter.ofPattern("MMddyyyy"));

        actor.attemptsTo(
                SendKeys.of(fechaParaInput).into(FormularioDePregutasPage.INPUT_INGRESAR_FECHA)
        );
    }

    public static OperacionFecha delCalculo() {
        return instrumented(OperacionFecha.class);
    }
}
