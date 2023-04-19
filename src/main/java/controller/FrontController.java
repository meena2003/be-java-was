package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import util.ContentType;
import view.ViewResolver;
import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;

public class FrontController {
    private static final Logger log = LoggerFactory.getLogger(FrontController.class);

    public void handleRequest(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
        String uri = httpRequest.getUri();

        // uri가 "/"이면 홈 화면을 출력한다
        if (uri.equals("/")) {
            uri = "/index.html";
        }

        // uri가 "/user/create"라면 회원 가입
        if (uri.startsWith("/user/create")) {
            String userId = httpRequest.getQueryParameter("userId");
            String password = httpRequest.getQueryParameter("password");
            String name = httpRequest.getQueryParameter("name");
            String email = httpRequest.getQueryParameter("email");
            UserService.join(userId, password, name, email);

            // 다시 홈 화면 uri를 요청한다.
            uri = "/index.html";
        }

        // 요청받은 파일을 처리한다
        ContentType contentType = ContentType.getContentType(uri);
        ViewResolver.resolveView(uri, contentType, httpResponse);
    }
}
