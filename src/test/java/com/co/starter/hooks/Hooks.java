package com.co.starter.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void SetUp(){
        OnStage.setTheStage(new OnlineCast()); // Inicializa el "casting"
        OnStage.theActorCalled("Andres Correa"); // Crea un actor
    }
}
