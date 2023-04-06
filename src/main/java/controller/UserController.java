package controller;

import model.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import service.UserService;
import webserver.HttpRequest;

/**
 * 유저와 관련된 기능을 수행하는 클래스
 * uri 키워드에 따라 회원가입, 수정, 삭제 등의 기능 수행
 */
public class UserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    UserService userService = new UserService();
    @Override
    public void run(HttpRequest httpRequest) {
        createUser(httpRequest);
    }

    public void createUser(HttpRequest httpRequest) {
        String userId = httpRequest.getQueryParameter().get("userId");
        String password = httpRequest.getQueryParameter().get("password");
        String name = httpRequest.getQueryParameter().get("name");
        String email = httpRequest.getQueryParameter().get("email");
        User user = new User(userId, password, name, email);
        log.debug("user : {}", user);
        userService.join(user);
    }
}
