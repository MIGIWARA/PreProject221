package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {

    void getAddUser(User user);

    List<User> listUsers();

    @SuppressWarnings("unchecked")
    User getUserByCar(String model, int series);
}
