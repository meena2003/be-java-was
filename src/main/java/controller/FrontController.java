package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;

public class FrontController {
    private static final Logger log = LoggerFactory.getLogger(FrontController.class);

    public void handleRequest(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        String uri = httpRequest.getUri();

        // 컨텐트 타입에 해당하는 확장자가 있다면,
        // accept에 해당하는 확장자가 있다면,

        // 정적 페이지를 처리하는 것인지, 아닌지를 해결하자.

        if (uri.equals("/")) {
            byte[] body = httpResponse.readFileFromTemplates("/index.html");
            httpResponse.response200HeaderHTML(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/index.html")) {
            byte[] body = httpResponse.readFileFromTemplates("/index.html");
            httpResponse.response200HeaderHTML(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/user/form.html")) {
            byte[] body = httpResponse.readFileFromTemplates("/user/form.html");
            httpResponse.response200HeaderHTML(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.startsWith("/user/create")) {
            String userId = httpRequest.getQueryParameter("userId");
            String password = httpRequest.getQueryParameter("password");
            String name = httpRequest.getQueryParameter("name");
            String email = httpRequest.getQueryParameter("email");
            UserService.join(userId, password, name, email);

            byte[] body = httpResponse.readFileFromTemplates("/index.html");
            httpResponse.response200HeaderHTML(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/css/styles.css")) {
            byte[] body = httpResponse.readFileFromStatic("/css/styles.css");
            httpResponse.response200HeaderCSS(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/css/styles.css")) {
            byte[] body = httpResponse.readFileFromStatic("/css/styles.css");
            httpResponse.response200HeaderCSS(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/css/bootstrap.min.css")) {
            byte[] body = httpResponse.readFileFromStatic("/css/bootstrap.min.css");
            httpResponse.response200HeaderCSS(body.length);
            httpResponse.responseBody(body);
        }

        if (uri.equals("/favicon.ico")) {
            byte[] body = httpResponse.readFileFromStatic("/favicon.ico");
            httpResponse.response200HeaderFavicon(body.length);
            httpResponse.responseBody(body);
        }
    }
}
