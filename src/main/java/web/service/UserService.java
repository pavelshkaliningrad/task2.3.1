package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getList ();
    User getById (int id);
    void add (User user);
    void createTable ();
    void deleteById (int id);
    void update (User userUpdate);
}
