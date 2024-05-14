package web.Dao;

import Hiber.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User show(int s);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
