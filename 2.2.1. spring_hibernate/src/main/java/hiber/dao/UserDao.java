package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   void removeUserById(Long id);

   User getUserById(Long id);

   List<User> listUsers();
}
