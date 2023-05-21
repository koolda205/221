package hiber.service;

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

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Override
   public void removeUserById(Long id){
      userDao.removeUserById(id);
   }
   @Override
   public User getUserById(Long id){
      return userDao.getUserById(id);
   }
   @Override
   public void getUserByCarId(int carId){
      userDao.getUserByCarId(carId);
   }

}
