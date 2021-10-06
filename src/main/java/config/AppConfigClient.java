package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class AppConfigClient {
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(AppConfigClient.class, args);
    }

    @RequestMapping("/")
    public String inicio(){
        List<ServiceInstance> instancias = discoveryClient.getInstances("CLIENTE1");
        return "Hola mundo " + instancias.get(0).getHost();
    }

}
