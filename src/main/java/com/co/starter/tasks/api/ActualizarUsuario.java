package main.java.com.co.starter.tasks.api;

import interactions.PostRequest;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarUsuario implements Task {

    public static ActualizarUsuario conDatosValidos() {
        return instrumented(ActualizarUsuario.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        Map<String, Object> body = new HashMap<>();
        body.put("nombre", "Usuario Actualizado");

        actor.attemptsTo(
                PostRequest.to("/usuarios/1", body)
        );
    }
}
