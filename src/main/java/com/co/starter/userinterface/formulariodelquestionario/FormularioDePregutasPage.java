package com.co.starter.userinterface.formulariodelquestionario;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FormularioDePregutasPage {
    public static final Target TEXTO_OPERACION_MATEMATICA = Target.the("Texto de la operación matematica").located(By.xpath("/html/body/div[2]/form/div[1]/div[1]/p[2]"));
    public static final Target TEXTO_DE_LA_FECHA = Target.the("Texto que contiene días y fecha base").located(By.xpath("/html/body/div[2]/form/div[1]/div[2]/p"));
    public static final Target TEXTO_DE_REPETIR_LETRA = Target.the("Texto para repetir letra").located(By.xpath("/html/body/div[2]/form/div[1]/div[3]/p"));
    public static final Target CHECK_RESULTADO_OPERACION_MATEMATICA(String valor) { return Target.the("radio button del resultado de la operación matematica" + valor).located(By.cssSelector("input[type='radio'][value='" + valor + "']"));}
    public static final Target INPUT_INGRESAR_FECHA = Target.the("Input para ingresa la fecha").located(By.xpath("/html/body/div[2]/form/div[1]/div[2]/input"));
    public static final Target INPUT_REPETIR_LETRA = Target.the("Unput par aingresar una letra varias veces").located(By.xpath("/html/body/div[2]/form/div[1]/div[3]/textarea"));
    public static final Target INPUT_CANTIDAD_RATONES = Target.the("Input par aingresa la cantidad de la secuencia").located(By.xpath("/html/body/div[2]/form/div[1]/div[4]/input"));
    public static final Target BUTTON_ENVIAR_FORMULARIO = Target.the("Boton par aneviar el formulario").located(By.xpath("/html/body/div[2]/form/div[2]/button"));
    public static final Target TEXT_CONTEO_CICLOS = Target.the("Texto del conteo de ciclos").located(By.xpath("/html/body/div[2]/div/div/div/p[2]"));
    public static final Target OBTNER_EMOJIN_DEL_TEXTO = Target.the("emoji a buscar").located(By.xpath("/html/body/div[2]/form/div[1]/div[4]/div/p[1]"));
    public static final Target BUSCAR_EMOJIN_EN_EL_CONSECUTIVO = Target.the("secuencia de emojis").located(By.xpath("/html/body/div[2]/form/div[1]/div[4]/div/p[2]"));

}
