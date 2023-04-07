package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;
import util.UserUtil;
import webserver.HttpRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private static final Logger log = LoggerFactory.getLogger(FrontController.class);
    private Map<String, Controller> controllerMap;

    public FrontController() {
        controllerMap = new HashMap<>();
        controllerMap.put("/", new HomeController());
        controllerMap.put("/index.html", new HomeController());
        controllerMap.put("/user/create", new UserController());
    }

    public String handleRequest(HttpRequest httpRequest) throws IOException {
        String uriPath = httpRequest.getHttpUriPath();
        log.debug("uriRootPath : {}", uriPath);

        Controller controller = controllerMap.get(uriPath);
        if (controller == null) {
            log.error("Requested resource not found");
        }
        return controller.handle(httpRequest);
    }

    public interface Controller {
        String handle(HttpRequest httpRequest);
    }

    public class UserController implements Controller {
        @Override
        public String handle(HttpRequest httpRequest) {
            UserService userService = new UserService();
            userService.join(UserUtil.createUser(httpRequest)); // 유저 가입
            return "/Index.html";
        }
    }

    public class HomeController implements Controller {
        @Override
        public String handle(HttpRequest httpRequest) {
            return "/Index.html";
        }
    }
}
