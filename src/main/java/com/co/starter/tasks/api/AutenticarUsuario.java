package main.java.com.co.starter.tasks.api;

import interactions.PostRequest;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AutenticarUsuario implements Task {

    public static AutenticarUsuario conCredencialesValidas() {
        return instrumented(AutenticarUsuario.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {

        Map<String, Object> body = new HashMap<>();
        body.put("email", "test@test.com");
        body.put("password", "123456");

        actor.attemptsTo(
                PostRequest.to("/login", body)
        );
    }
}
