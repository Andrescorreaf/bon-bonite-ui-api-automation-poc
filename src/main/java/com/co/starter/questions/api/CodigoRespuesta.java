package com.co.starter.questions.api;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {

    public static CodigoRespuesta es() {
        return new CodigoRespuesta();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        Response response = actor.recall("response");
        return response.getStatusCode();
    }
}
