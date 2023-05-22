package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void removeUserById(Long id);

    User getUserById(Long id);

    void getUserByCarId(int id);

    void getUserByCar(String carModel, int carSeries);

}

