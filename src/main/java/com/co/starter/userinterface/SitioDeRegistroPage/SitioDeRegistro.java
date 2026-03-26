package com.co.starter.userinterface.SitioDeRegistroPage;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class SitioDeRegistro {

    public static final Target LINK_REGISTRATE = Target.the("Link Regístrate").located(By.id("show_register"));
    public static final Target LINK_LOGIN = Target.the("Link Iniciar Sesión").located(By.id("show_login"));
    public static final Target FORMULARIO_LOGIN = Target.the("Formulario de login").located(By.id("customer_login"));
    public static final Target FORMULARIO_REGISTRO = Target.the("Formulario de registro").located(By.xpath("//form[@id='form-register']") );

    public static final Target NUMERO_CEDULA = Target.the("Número de cédula").located(By.id("username"));
    public static final Target CONTRASENA = Target.the("Contraseña").located(By.id("password"));
    public static final Target BTN_LOGIN = Target.the("Botón de login").located(By.name("login"));

    // Campos del formulario de registro
    public static final Target REG_CEDULA = Target.the("Número de cédula (registro)").located(By.id("reg_username"));
    public static final Target REG_NOMBRES = Target.the("Nombres (registro)").located(By.id("first_name"));
    public static final Target REG_APELLIDOS = Target.the("Apellidos (registro)").located(By.id("last_name"));
    public static final Target REG_EMAIL = Target.the("Correo electrónico (registro)").located(By.id("reg_email"));
    public static final Target REG_CONTRASENA = Target.the("Contraseña (registro)").located(By.id("reg_password"));
    public static final Target REG_CONFIRMAR_CONTRASENA = Target.the("Confirmar contraseña (registro)").located(By.id("reg_password2"));
    public static final Target CHECK_NEWSLETTER = Target.the("Suscripción newsletter").located(By.id("newsletter_authorization"));
    public static final Target CHECK_PRIVACY_POLICY = Target.the("Aceptar políticas de privacidad").located(By.id("privacy_policy_reg"));
    public static final Target BTN_REGISTRAR = Target.the("Botón registrarme").located(By.name("register"));

    public static final Target TITULO_CUENTA = Target.the("Título de cuenta").located(By.xpath("//h3[contains(text(),'Hola')]") );
    public static final Target LOGOUT_LINK = Target.the("Link Cerrar sesión").located(By.xpath("//a[contains(normalize-space(.),'Cerrar sesión') or contains(normalize-space(.),'Logout')]") );

    public static final Target TITULO_REGISTRO = Target.the("Título de registro").located(By.xpath("//h2[contains(text(),'Crea tu cuenta')]") );

    public static final Target MENSAJE_BIENVENIDA = Target.the("Mensaje de bienvenida").located(By.cssSelector("body > div.grow > div > div > div > div.lg\\:py-12.py-6.flex.flex-col.lg\\:flex-row.lg\\:justify-between.lg\\:items-center.px-4.lg\\:px-12 > div.max-w-2xl > h3"));
}
