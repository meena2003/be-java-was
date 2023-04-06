package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private static final Logger log = LoggerFactory.getLogger(FrontController.class);
    private Map<String, Handler> handlerMap;

    public FrontController() {
        handlerMap = new HashMap<>();

        handlerMap.put("/", new HomeHandler());
        handlerMap.put("/index.html", new HomeHandler());
        handlerMap.put("/user", new UserHandler());
    }

    public void handleRequest(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        String uriPath = httpRequest.getHttpUriPath();
        Handler handler = handlerMap.get(uriPath);
        if (handler == null) {
            log.error("Requested resource not found");
        }
        handler.handle(httpRequest, httpResponse);
    }

    public interface Handler {
        void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException;
    }

    public class HomeHandler implements Handler {
        @Override
        public void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
            String uri = httpRequest.getHttpUriPath();
            byte[] body = httpResponse.readFile(uri);
            httpResponse.response200Header(body.length);
            httpResponse.responseBody(body);
        }
    }

    public class UserHandler implements Handler {
        @Override
        public void handle(HttpRequest httpRequest, HttpResponse httpResponse) {

        }
    }
}
