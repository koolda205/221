package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru,", new Car("Lada1", 1)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru,", new Car("Lada2", 2)));
      userService.add(new User("User3", "Lastname3", "user2@mail.ru,", new Car("Lada3", 3)));
      userService.add(new User("User4", "Lastname4", "user2@mail.ru,", new Car("Lada4", 4)));
      userService.add(new User("User5", "Lastname5", "user2@mail.ru,", new Car("Lada5", 5)));
      userService.add(new User("User6", "Lastname6", "user2@mail.ru,", new Car("Lada6", 6)));
      userService.add(new User("User7", "Lastname7", "user2@mail.ru,", new Car("Lada7", 7)));
      userService.add(new User("User8", "Lastname82", "user2@mail.ru,", new Car("Lada8", 8)));
      userService.add(new User("User22", "Lastname22", "user22@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User222", "Lastname222", "user2@mail.ru"));
      userService.add(new User("User31", "Lastname31", "user31@mail.ru"));
      userService.add(new User("User43", "Lastname43", "user43@mail.ru"));

//      userService.add(new Car("Lada3", 3).getUser());
//      userService.add(new Car("Lada4", 4).getUser());
//      userService.add(new Car("Lada5", 5).getUser());
//      userService.add(new Car("Lada6", 6).getUser());
//      userService.add(new Car("Lada7", 7).getUser());

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+ user.getId());
         System.out.println("First Name = "+ user.getFirstName());
         System.out.println("Last Name = "+ user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
      }

      userService.getUserById(7L);
      userService.removeUserById(8L);

      userService.getUserByCarId (9);
      userService.getUserByCar("Lada8", 8);

      context.close();
   }
}
