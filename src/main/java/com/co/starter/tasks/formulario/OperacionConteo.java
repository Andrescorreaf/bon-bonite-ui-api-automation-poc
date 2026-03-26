package com.co.starter.tasks.formulario;

import com.co.starter.userinterface.formulariodelquestionario.FormularioDePregutasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OperacionConteo implements Task {

    public static OperacionConteo cantidad(){
        return instrumented(OperacionConteo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener emoji del p[1]
        String textoEmoji = Text.of(FormularioDePregutasPage.OBTNER_EMOJIN_DEL_TEXTO).answeredBy(actor);
        String emoji = textoEmoji.replaceAll(".*([\\p{So}\\p{Cn}]).*", "$1");

        // Obtener la secuencia del p[2]
        String secuencia = Text.of(FormularioDePregutasPage.BUSCAR_EMOJIN_EN_EL_CONSECUTIVO).answeredBy(actor);

        // Contar cuántas veces aparece el emoji
        int cantidad = secuencia.split(java.util.regex.Pattern.quote(emoji), -1).length - 1;

        actor.attemptsTo(
                SendKeys.of(String.valueOf(cantidad))
                        .into(FormularioDePregutasPage.INPUT_CANTIDAD_RATONES));

    }

}
