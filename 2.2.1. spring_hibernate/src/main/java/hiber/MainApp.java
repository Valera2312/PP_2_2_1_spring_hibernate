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
      Car car = new Car("Tesla","Model X");
      Car car2 = new Car("Toyota","Mark2");

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",car));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru",car2));

      List<User> users = userService.listUsersByCar("Tesla","Model X");
      System.out.println(users.size());
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
