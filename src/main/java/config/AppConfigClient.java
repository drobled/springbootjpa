package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class AppConfigClient {
    @Autowired
    SaludoServer saludoServer;

    public static void main(String[] args) {
        SpringApplication.run(AppConfigClient.class, args);
    }

    @FeignClient("SaludoServer")
    interface SaludoServer{
        @RequestMapping(value = "/",method = RequestMethod.GET)
        String saludo();
    }

    @RequestMapping("/")
    public String inicio(){
        return "Saludo cliente " + saludoServer.saludo();
    }

}
