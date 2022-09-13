package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class EntityManagerUserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select c from User c", User.class).getResultList();
    }
    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void createTable() {
        entityManager.createNativeQuery("CREATE TABLE if not Exists Users (id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT , name  CHAR(50), lastName CHAR(50))").executeUpdate();
    }

    @Override
    public void update(User userUpdate) {
        User user = this.getById(userUpdate.getId());
        user.setName(userUpdate.getName());
        user.setLastName(userUpdate.getLastName());
    }

    @Override
    public void deleteByID (int id) {
        entityManager.remove(this.getById(id));
    }
}
