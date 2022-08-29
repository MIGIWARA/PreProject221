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

      User user1 = new User("Bob", "Block", "Bb@mail.ru");
      User user2 = new User("Gon", "Gunner", "Gg@mail.ru");
      User user3 = new User("Alex", "Alman", "Aa@mail.ru");
      User user4 = new User("Ken", "Krock", "Kk@mail.ru");


      Car car1 = new Car("BMW", 100);
      Car car2 = new Car("Mercedes", 101);
      Car car3 = new Car("Kia", 102);
      Car car4 = new Car("Lamborghini", 103);
      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         }
         System.out.println();
      }

      System.out.println(userService.getUserByCar("mazda", 23));

      context.close();
   }
}