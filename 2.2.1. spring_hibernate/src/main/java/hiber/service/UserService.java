package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void add(Car car);

    List<User> listUsers();
    List<Car> listCars();

    void removeUserById(Long id);
    void removeCarById(Long id);

    User getUserById(Long id);
    Car getCarById(Long id);

    void getUserByCarId(int id);

    void getUserByCar(String carModel, int carSeries);

}

