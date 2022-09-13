package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserServiceImlp implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getList() {
        return userDao.getAll();
    }
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    @Override
    public void createTable() {
        userDao.createTable();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userDao.deleteByID(id);
    }

    @Transactional
    @Override
    public void update (User userUpdate) {
        userDao.update(userUpdate);
    }
}
