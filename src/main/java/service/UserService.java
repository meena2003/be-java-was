package service;

import db.Database;
import model.User;

public class UserService {

    public void join(User user) {
        Database.addUser(user);
    }
}
