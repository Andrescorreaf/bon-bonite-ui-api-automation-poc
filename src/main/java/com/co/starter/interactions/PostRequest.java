package com.co.starter.interactions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRequest implements Interaction {

    private final String endpoint;
    private final Object body;

    public PostRequest(String endpoint, Object body) {
        this.endpoint = endpoint;
        this.body = body;
    }

    public static PostRequest to(String endpoint, Object body) {
        return instrumented(PostRequest.class, endpoint, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = SerenityRest
                .given()
                .contentType("application/json")
                .body(body)
                .post(endpoint);

        actor.remember("response", response);
    }
}
