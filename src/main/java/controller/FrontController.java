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

        ContentType contentType = ContentType.getContentType(uri);
        ViewResolver.resolveView(uri, contentType, httpResponse);

        // 컨텐트 타입에 해당하는 확장자가 있다면,
        // accept에 해당하는 확장자가 있다면,

        // 정적 페이지를 처리하는 것인지, 아닌지를 해결하자.

//        if (uri.startsWith("/user/create")) {
//            String userId = httpRequest.getQueryParameter("userId");
//            String password = httpRequest.getQueryParameter("password");
//            String name = httpRequest.getQueryParameter("name");
//            String email = httpRequest.getQueryParameter("email");
//            UserService.join(userId, password, name, email);
//
//            byte[] body = httpResponse.readFile("/index.html", contentType);
//            httpResponse.response200Header(body.length);
//            httpResponse.responseBody(body);
//        }
    }
}
