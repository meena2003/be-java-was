package controller;

import service.UserService;
import util.HttpRequestUtils;

public class HttpRequestController {
    private HttpRequestUtils httpRequestUtils;
    private UserService userService;

    public HttpRequestController(HttpRequestUtils httpRequestUtils) {
        this.httpRequestUtils = httpRequestUtils;
    }

//    public void handleUrl(String requestLine) {
//        String url = httpRequestUtils.getRequestLineHttpURI();
//        if (url.startsWith("user/create")) {
//
//            userService.join();  // 회원가입하기
//        }
//    }
}
