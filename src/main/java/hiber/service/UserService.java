package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    @Transactional
    void addCar(Car car);

    List<User> listUsers();

    @Transactional(readOnly = true)
    User getUserByCar(Car car);
}