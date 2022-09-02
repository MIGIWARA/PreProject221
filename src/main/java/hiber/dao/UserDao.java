package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getListUsers();

    @SuppressWarnings("unchecked")
    User getUserByCar(String model, int series);
}
