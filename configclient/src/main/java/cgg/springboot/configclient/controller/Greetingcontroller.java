package cgg.springboot.configclient.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Greetingcontroller
 */
@RestController
@RefreshScope
public class Greetingcontroller {

  @Value("${my.greeting}")
  private String greetMsg;

  @Value("${my.list.values}")
  private List<String> listValues;

  @Autowired
  private DbSettings dbSettings;

  @GetMapping("/greeting")
  public String greeting() {
    return greetMsg + " " + listValues + " " + dbSettings;
  }
}
