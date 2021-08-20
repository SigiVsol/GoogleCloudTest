package be.vsol.googlecloudtest;

import be.vsol.commons.http.*;
import be.vsol.commons.util.Json;
import org.json.JSONObject;

public class RestApi extends RestHandler {
    private final Db db;

    public RestApi(Db db) {
        this.db = db;
    }

    @GetMapping(path = "/clients/*")
    public HttpResponse test(HttpRequest request, String name) {
        JSONObject jsonResult = new JSONObject(); {
            jsonResult.put("name", name);
            jsonResult.put("age", name.length());
        }

        return new HttpResponse(jsonResult);
    }

    @PostMapping(path = "/clients")
    public HttpResponse postClient(HttpRequest request, JSONObject jsonObject) {
        Client client = Json.get(jsonObject, Client::new);
        db.getClients().save(client);

        return new HttpResponse("Client " + client.getName() + " added!");
    }

}
