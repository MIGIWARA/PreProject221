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


        userService.add(new User("Bob", "Block", "Bb@mail.ru", new Car("BMW", 100)));
        userService.add(new User("Gon", "Gunner", "Gg@mail.ru", new Car("Mercedes", 101)));
        userService.add(new User("Alex", "Alman", "Aa@mail.ru", new Car("Kia", 102)));
        userService.add(new User("Ken", "Krock", "Kk@mail.ru", new Car("Lamborghini", 103)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
                System.out.println("Car = " + user.getCar() + " " + user.getCar());
            }
            System.out.println();
        }

        System.out.println(userService.getUserByCar("Lamborghini", 103));

        context.close();
    }
}