package controller;

import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;

//public class UserHandler implements Handler {
//    @Override
//    public void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException {
//        controller = new UserController();
//        controller.run(httpRequest);
//        String uri = httpRequest.getHttpUriPath();
//        log.debug("회원가입 눌렀을 때 uri = {}", uri);
//        byte[] body = httpResponse.readFile(uri);
//        httpResponse.response200Header(body.length);
//        httpResponse.responseBody(body);
//    }
//}
