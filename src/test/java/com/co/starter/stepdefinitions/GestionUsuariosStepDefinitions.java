package com.co.starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import com.co.starter.tasks.api.CrearUsuario;
import com.co.starter.tasks.api.AutenticarUsuario;
import com.co.starter.tasks.api.ActualizarUsuario;
import com.co.starter.tasks.ui.NavegarARegistro;
import com.co.starter.tasks.ui.RegistrarUsuarioUI;

import com.co.starter.questions.api.CodigoRespuesta;
import com.co.starter.questions.api.TokenValido;
import com.co.starter.questions.api.UsuarioCreado;
import com.co.starter.questions.ui.MensajeConfirmacion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class GestionUsuariosStepDefinitions {

    private final Actor actor = OnStage.theActorCalled("Andres Correa");

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

    // =====================================================
    // 🔥 API - LOGIN
    // =====================================================

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

    // =====================================================
    // 🔥 API - ACTUALIZAR USUARIO
    // =====================================================

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
        actor.attemptsTo(
                CrearUsuario.conDatosInvalidos()
        );
    }

    @Cuando("envía la solicitud al servicio de registro")
    public void enviarSolicitudInvalida() {
        actor.attemptsTo(
                CrearUsuario.enviar()
        );
    }

    @Entonces("el sistema responde con error de validación")
    public void validarError() {
        actor.should(
                seeThat("Código de error",
                        CodigoRespuesta.es(), is(400))
        );
    }

    @Y("no permite la creación del usuario")
    public void validarNoCreacion() {
        actor.should(
                seeThat(UsuarioCreado.correctamente(), is(false))
        );
    }


    @Dado("que el actor navega al sitio web de e-commerce")
    public void navegarSitio() {
        actor.attemptsTo(
                NavegarARegistro.paginaPrincipal()
        );
    }

    @Y("accede al formulario de registro")
    public void accederFormulario() {
        actor.attemptsTo(
                NavegarARegistro.formularioRegistro()
        );
    }

    @Cuando("ingresa información válida en todos los campos obligatorios")
    public void ingresarDatosUI() {
        actor.attemptsTo(
                RegistrarUsuarioUI.conDatosValidos()
        );
    }

    @Y("envía el formulario de registro")
    public void enviarFormularioUI() {
        actor.attemptsTo(
                RegistrarUsuarioUI.enviar()
        );
    }

    @Entonces("el sistema muestra un mensaje de confirmación")
    public void validarMensaje() {
        actor.should(
                seeThat(MensajeConfirmacion.visible(), is(true))
        );
    }

    @Y("el usuario queda registrado exitosamente")
    public void validarUsuarioRegistrado() {
        actor.should(
                seeThat(MensajeConfirmacion.visible(), is(true))
        );
    }

}