package com.co.starter.questions.api;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TokenValido implements Question<Boolean> {

    public static TokenValido existe() {
        return new TokenValido();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall("response");
        String token = response.jsonPath().getString("token");
        return token != null && !token.isEmpty();
    }
}
