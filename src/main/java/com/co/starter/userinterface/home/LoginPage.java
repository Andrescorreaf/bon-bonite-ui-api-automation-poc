package com.co.starter.userinterface.home;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target USUARIO = Target.the("Usuario para ingresar a la prueba").located(By.xpath("/html/body/div/div[2]/form/input[1]"));
    public static final Target CONTRASENA = Target.the("Contraseña para ingresar a la prueba").located(By.xpath("/html/body/div/div[2]/form/input[2]"));
    public static final Target BOTON_INGRESAR = Target.the("Botón par aingresar a la prueba").located(By.xpath("/html/body/div/div[2]/form/button"));
}
