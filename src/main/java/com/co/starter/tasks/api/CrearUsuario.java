package com.co.starter.tasks.api;

import com.co.starter.interactions.PostRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearUsuario implements Task {

    private final Map<String, Object> body;

    public CrearUsuario(Map<String, Object> body) {
        this.body = body;
    }

    public static CrearUsuario conDatosValidos() {
        Map<String, Object> body = new HashMap<>();
        body.put("email", "test@test.com");
        body.put("password", "123456");

        return instrumented(CrearUsuario.class, body);
    }

    public static CrearUsuario conDatosInvalidos() {
        Map<String, Object> body = new HashMap<>();
        body.put("email", "");

        return instrumented(CrearUsuario.class, body);
    }

    public static Task enviar() {
        return Task.where("{0} envía la solicitud de creación",
                PostRequest.to("/usuarios", new HashMap<>())
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostRequest.to("/usuarios", body)
        );
    }
}
