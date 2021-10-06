package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigClient.class, args);
    }

    @RequestMapping("/")
    public String inicio(){
        return "Hola mundo";
    }

}
