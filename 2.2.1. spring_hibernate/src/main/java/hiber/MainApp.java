package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.Transaction;
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

//      User user1 = new User("User11", "Lastname11", "user33333311@mail.ru");
//      Car car1 = new Car("Lada11", 11);
//      userService.add(user1);
//      userService.add(car1);
//      User user2 = new User("User22", "Lastname22", "user33333311@mail.ru");
//      Car car2 = new Car("Lada22", 22);
//      userService.add(user2);
//      userService.add(car2);
//      User user3 = new User("User33", "Lastname33", "user33333311@mail.ru");
//      Car car3 = new Car("Lada33", 33);
//      userService.add(user3);
//      userService.add(car3);
//      User user4 = new User("User44", "Lastname44", "user33333311@mail.ru");
//      Car car4 = new Car("Lada44", 44);
//      userService.add(user4);
//      userService.add(car4);
//
//      user1.setCar(car1);
//      user2.setCar(car2);
//      user3.setCar(car3);
//      user4.setCar(car4);
//
//      car1.setUser(user1);
//      car2.setUser(user2);
//      car3.setUser(user3);
//      car4.setUser(user4);



//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//      userService.add(new User("User222", "Lastname222", "user2@mail.ru"));
//      userService.add(new User("User31", "Lastname31", "user31@mail.ru"));
//      userService.add(new User("User43", "Lastname43", "user43@mail.ru"));
//
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

      userService.getUserByCarId (2);
      userService.getUserById(3L);
      userService.removeUserById(10L);
      System.out.println("==============================");
      userService.getUserByCar("Lada1", 1);
      context.close();
   }
}
