package main.java.com.co.starter.questions.api;

public class UsuarioCreado implements Question<Boolean> {

    public static UsuarioCreado correctamente() {
        return new UsuarioCreado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = actor.recall("response");
        return response.getStatusCode() == 200;
    }
}