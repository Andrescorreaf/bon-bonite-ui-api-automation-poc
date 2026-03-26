package com.co.starter.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;

public class Hooks {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        Actor actor = OnStage.theActorCalled("Andres Correa");

        // 👉 Abre la URL definida en serenity.conf (baseUrl)
        actor.attemptsTo(
                Open.url("/")
        );
    }
}