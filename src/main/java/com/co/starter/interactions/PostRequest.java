package main.java.com.co.starter.interactions;


public class PostRequest implements Interaction {

    private String endpoint;
    private Object body;

    public PostRequest(String endpoint, Object body) {
        this.endpoint = endpoint;
        this.body = body;
    }

    public static PostRequest to(String endpoint, Object body) {
        return instrumented(PostRequest.class, endpoint, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = SerenityRest
                .given()
                .contentType("application/json")
                .body(body)
                .post(endpoint);

        actor.remember("response", response);
    }
}