package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll ();

    User getById (int id);
    void add (User user);
    void createTable ();
    void deleteByID (int id);
    void update (User userUpdate);
}
