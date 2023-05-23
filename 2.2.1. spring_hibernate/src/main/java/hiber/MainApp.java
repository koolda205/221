package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User11", "Lastname11", "user33333311@mail.ru");
        Car car1 = new Car("Lada11", 11);
        userService.add(user1.setCar(car1));
        userService.add(car1.setUser(user1));
        User user2 = new User("User22", "Lastname22", "user33333311@mail.ru");
        Car car2 = new Car("Lada22", 22);
        userService.add(user2.setCar(car2));
        userService.add(car2.setUser(user2));
        User user3 = new User("User33", "Lastname33", "user33333311@mail.ru");
        Car car3 = new Car("Lada33", 33);
        userService.add(user3.setCar(car3));
        userService.add(car3.setUser(user3));
        User user4 = new User("User44", "Lastname44", "user33333311@mail.ru");
        Car car4 = new Car("Lada44", 44);
        userService.add(user4.setCar(car4));
        userService.add(car4.setUser(user4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
        }

        userService.getUserByCarId(2);

        userService.getUserById(3L);

        userService.removeUserById(10L);

        System.out.println("==============================");

        userService.getUserByCar("Lada1", 1);

        context.close();
    }
}
