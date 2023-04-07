package util;

import model.User;
import webserver.HttpRequest;

import java.util.Map;

public class UserUtil {
    public static User createUser(HttpRequest httpRequest) {
        Map<String, String> userInfo = httpRequest.getQueryParameter();
        return new User(userInfo.get("userId"), userInfo.get("password"), userInfo.get("name"), userInfo.get("email"));
    }
}
