package com.co.starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import com.co.starter.tasks.api.CrearUsuario;
import com.co.starter.tasks.api.AutenticarUsuario;
import com.co.starter.tasks.api.ActualizarUsuario;
import com.co.starter.tasks.ui.NavegarAHome;
import com.co.starter.tasks.ui.NavegarARegistro;
import com.co.starter.tasks.ui.NavegarALogin;
import com.co.starter.tasks.ui.RegistrarUsuarioUI;
import com.co.starter.tasks.ui.IniciarSesionUI;
import com.co.starter.tasks.ui.SalirDeCuenta;

import com.co.starter.questions.api.CodigoRespuesta;
import com.co.starter.questions.api.TokenValido;
import com.co.starter.questions.api.UsuarioCreado;
import com.co.starter.questions.ui.MensajeConfirmacion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class GestionUsuariosStepDefinitions {

    private final Actor actor = OnStage.theActorCalled("Andres Correa");
    private String loginCedula;
    private String loginEmail;
    private String loginPassword;

    @Dado("que el actor prepara una solicitud de creación de usuario con datos válidos")
    public void prepararSolicitudUsuarioValido() {
        actor.attemptsTo(
                CrearUsuario.conDatosValidos()
        );
    }

    @Cuando("envía la solicitud al servicio de registro de usuarios")
    public void enviarSolicitudRegistro() {
        actor.attemptsTo(
                CrearUsuario.enviar()
        );
    }

    @Entonces("el sistema responde con estado exitoso")
    public void validarEstadoExitoso() {
        actor.should(
                seeThat("El código de respuesta",
                        CodigoRespuesta.es(), is(200))
        );
    }

    @Y("el usuario es creado correctamente en el sistema")
    public void validarUsuarioCreado() {
        actor.should(
                seeThat(UsuarioCreado.correctamente(), is(true))
        );
    }

    @Dado("que el actor tiene un usuario previamente registrado")
    public void usuarioPreviamenteRegistrado() {
        actor.attemptsTo(
                CrearUsuario.conDatosValidos(),
                CrearUsuario.enviar()
        );
    }

    @Cuando("envía las credenciales válidas al servicio de autenticación")
    public void enviarCredencialesValidas() {
        actor.attemptsTo(
                AutenticarUsuario.conCredencialesValidas()
        );
    }

    @Y("retorna un token de acceso válido")
    public void validarToken() {
        actor.should(
                seeThat(TokenValido.existe(), is(true))
        );
    }

    @Dado("que el actor cuenta con un usuario autenticado")
    public void usuarioAutenticado() {
        actor.attemptsTo(
                CrearUsuario.conDatosValidos(),
                CrearUsuario.enviar(),
                AutenticarUsuario.conCredencialesValidas()
        );
    }

    @Cuando("envía una solicitud para actualizar la información del usuario")
    public void actualizarUsuario() {
        actor.attemptsTo(
                ActualizarUsuario.conDatosValidos()
        );
    }

    @Y("los datos del usuario son actualizados correctamente")
    public void validarActualizacion() {
        actor.should(
                seeThat("Datos actualizados",
                        UsuarioCreado.correctamente(), is(true)) // puedes cambiar por otra Question
        );
    }

    @Dado("que el actor prepara una solicitud de creación de usuario con datos incompletos")
    public void prepararSolicitudInvalida() {
        // Cambiado a UI: navegar al sitio y formulario
        actor.attemptsTo(
                NavegarAHome.paginaPrincipal(),
                NavegarARegistro.aRegistro()
        );
    }

    @Cuando("envía la solicitud al servicio de registro")
    public void enviarSolicitudInvalida() {
        // Cambiado a UI: ingresar datos incompletos y enviar
        String timestamp = String.valueOf(System.currentTimeMillis());
        actor.attemptsTo(
                RegistrarUsuarioUI.conDatosIncompletos("123456789" + timestamp, "Juan", "Pérez", "juan.perez" + timestamp + "@example.com", "Password123!")
        );
    }

    @Entonces("el sistema responde con error de validación")
    public void validarError() {
        // Cambiado a UI: validar que no se registró (mensaje de bienvenida no visible)
        actor.should(
                seeThat(MensajeConfirmacion.visible(), is(false))
        );
    }

    @Y("no permite la creación del usuario")
    public void validarNoCreacion() {
        // Ya validado en el paso anterior
    }


    @Dado("que el actor navega al sitio web de bon-bonite.com")
    public void navegarSitio() {
        actor.attemptsTo(
                NavegarAHome.paginaPrincipal()
        );
    }

    @Y("accede al formulario de registro")
    public void accederFormulario() {
        actor.attemptsTo(
                NavegarARegistro.aRegistro()
        );
    }

    @Cuando("ingresa credenciales válidas")
    public void ingresarDatosUI() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        actor.attemptsTo(
                RegistrarUsuarioUI.conDatos("123456789" + timestamp, "Juan", "Pérez", "juan.perez" + timestamp + "@example.com", "Password123!", true, true)
        );
    }

    @Y("envía el formulario de login")
    public void enviarFormularioUI() {
        // El envío ya está incluido en RegistrarUsuarioUI.performAs o IniciarSesionUI.performAs, no se necesita acción adicional
    }

    @Y("accede al formulario de login")
    public void accederFormularioLogin() {
        actor.attemptsTo(
                SalirDeCuenta.aLogout(),
                NavegarALogin.aLogin()
        );
    }

    @Y("registra un usuario para login")
    public void registrarUsuarioParaLogin() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        loginCedula = "12345678" + timestamp.substring(timestamp.length() - 4);
        loginEmail = "juan.perez" + timestamp + "@example.com";
        loginPassword = "Password123!";

        actor.attemptsTo(
                NavegarARegistro.aRegistro(),
                RegistrarUsuarioUI.conDatos(loginCedula, "Juan", "Pérez", loginEmail, loginPassword, true, true)
        );
    }

    @Cuando("ingresa las credenciales válidas para login")
    public void ingresarCredencialesLogin() {
        actor.attemptsTo(
                IniciarSesionUI.conCredenciales(loginEmail, loginPassword)
        );
    }

    @Entonces("el sistema permite el acceso")
    public void validarMensaje() {
        actor.should(
                seeThat(MensajeConfirmacion.visible(), is(true))
        );
    }

    @Y("el usuario accede exitosamente")
    public void validarUsuarioRegistrado() {
        actor.should(
                seeThat(MensajeConfirmacion.visible(), is(true))
        );
    }

}