package com.co.starter.userinterface.SitioDeRegistroPage;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class SitioDeRegistro {   

    public static final Target NUMERO_CEDULA = Target.the("Número de cédula").located(By.id("reg_username"));
    public static final Target EMAIL = Target.the("Email").located(By.id("reg_email"));
    public static final Target CONTRASENA = Target.the("Contraseña").located(By.id("reg_password"));
    public static final Target BTN_ACEPTAR_TERMINOS = Target.the("Botón de aceptar términos y condiciones").located(By.id("privacy_policy_reg"));
    public static final Target BTN_REGISTRAR = Target.the("Botón de registro").located(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/div[5]/button"));
    public static final Target TITULO_CUENTA = Target.the("Título de cuenta").located(By.xpath("/html/body/div[2]/div[1]/h1"));
}
