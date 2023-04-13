package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private static final Logger log = LoggerFactory.getLogger(FrontController.class);
    private final Map<String, Handler> handlerMap;

    public FrontController() {
        handlerMap = new HashMap<>();
//        handlerMap.put("/user", new UserHandler());
    }

    public void handleRequest(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        String uri = httpRequest.getUri();

        if (uri.equals("/")) {
            byte[] body = httpResponse.readFile("/index.html");
            httpResponse.response200Header(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/index.html")) {
            byte[] body = httpResponse.readFile("/index.html");
            httpResponse.response200Header(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/user/form.html")) {
            byte[] body = httpResponse.readFile("/user/form.html");
            httpResponse.response200Header(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.startsWith("/user/create")) {
            String userId = httpRequest.getQueryParameter("userId");
            String password = httpRequest.getQueryParameter("password");
            String name = httpRequest.getQueryParameter("name");
            String email = httpRequest.getQueryParameter("email");
            UserService.join(userId, password, name, email);

            byte[] body = httpResponse.readFile("/index.html");
            httpResponse.response200Header(body.length);
            httpResponse.responseBody(body);
        }
    }
}
