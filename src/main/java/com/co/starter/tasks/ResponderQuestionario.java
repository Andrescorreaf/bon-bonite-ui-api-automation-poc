package com.co.starter.tasks;

import com.co.starter.tasks.formulario.OperacionCampoTexto;
import com.co.starter.tasks.formulario.OperacionConteo;
import com.co.starter.tasks.formulario.OperacionFecha;
import com.co.starter.tasks.formulario.OperacionMatematica;
import com.co.starter.userinterface.formulariodelquestionario.FormularioDePregutasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ResponderQuestionario implements Task {
    private static final int CAN_CICLOS = 10;
    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 0; i < CAN_CICLOS; i++){
            // Pausa al llegar a la iteración 7
            /*
            if (i == 6 ) {
                String textoOperacion = Text.of(FormularioDePregutasPage.TEXTO_OPERACION_MATEMATICA)
                        .answeredBy(actor)
                        .trim();
                System.out.println("Pausa de 1 minuto en el ciclo " + (i + 1));
                System.out.println("Valores a sumar del ciclo 7" + textoOperacion);
                actor.attemptsTo(
                        WaitUntil.the(
                                FormularioDePregutasPage.CHECK_RESULTADO_OPERACION_MATEMATICA("13613698632"),
                                WebElementStateMatchers.isVisible()
                        ).forNoMoreThan(10).seconds(),
                        Click.on(FormularioDePregutasPage.CHECK_RESULTADO_OPERACION_MATEMATICA("13613698632")),
                        OperacionFecha.delCalculo(),
                        OperacionCampoTexto.repetir(),
                        OperacionConteo.cantidad(),
                        Click.on(FormularioDePregutasPage.BUTTON_ENVIAR_FORMULARIO)

                );
            }*/

            actor.attemptsTo(
                    OperacionMatematica.delCalculo(),
                    OperacionFecha.delCalculo(),
                    OperacionCampoTexto.repetir(),
                    OperacionConteo.cantidad(),
                    Click.on(FormularioDePregutasPage.BUTTON_ENVIAR_FORMULARIO)
            );

        }

    }
    public static ResponderQuestionario delFormulario(){
        return instrumented(ResponderQuestionario.class);
    }
}
