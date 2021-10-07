package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AppConfigClientServer {
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(AppConfigClientServer.class, args);
    }

    @RequestMapping("/")
    public String inicio() {
        List<ServiceInstance> instances = discoveryClient.getInstances("SaludoServer");
        ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
        return "Hola mundo servidor:" + serviceInstance.getServiceId() + ":"
                + serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }

}
