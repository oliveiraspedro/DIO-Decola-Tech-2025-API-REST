package dio.aula_spring_data_jpa;

import dio.aula_spring_data_jpa.Model.User;
import dio.aula_spring_data_jpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Pedro");
        user.setUserName("Peu");
        user.setPassword("123456");

        userRepository.save(user);


        for (User u : userRepository.findAll()){
            System.out.println(u);
        }
    }
}
