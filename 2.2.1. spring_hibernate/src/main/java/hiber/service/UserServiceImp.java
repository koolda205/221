package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarDao carDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional
   @Override
   public void add(Car car) {
      carDao.add(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return carDao.listCars();
   }
   @Override
   public void removeUserById(Long id){
      userDao.removeUserById(id);
   }

   @Override
   public void removeCarById(Long id){
      carDao.removeCarById(id);
   }
   @Override
   public User getUserById(Long id){
      return userDao.getUserById(id);
   }

   @Override
   public Car getCarById(Long id){
      return carDao.getCarById(id);
   }

   @Override
   public void getUserByCarId(int id){
      userDao.getUserByCarId(id);
   }

   @Override
   public void getUserByCar(String carModel, int carSeries){
      userDao.getUserByCar(carModel, carSeries );
   }

}
