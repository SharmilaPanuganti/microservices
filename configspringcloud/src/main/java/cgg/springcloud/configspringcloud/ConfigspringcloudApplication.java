package cgg.springcloud.configspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigspringcloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigspringcloudApplication.class, args);
  }
}
