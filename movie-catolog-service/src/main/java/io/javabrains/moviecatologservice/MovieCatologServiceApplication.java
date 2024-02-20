package io.javabrains.moviecatologservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatologServiceApplication {

  @Bean
  @LoadBalanced
  RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Bean
  @LoadBalanced
  RestClient getRestClient() {
    return RestClient.create();
  }

  @Bean
  @LoadBalanced
  RestClient.Builder getRestClientBuilder() {
    return RestClient.builder();
  }

  public static void main(String[] args) {
    SpringApplication.run(MovieCatologServiceApplication.class, args);
  }
}
