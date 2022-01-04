package com.iba.notificationservice;

import com.iba.notificationservice.enumeration.Status;
import com.iba.notificationservice.model.Service;
import com.iba.notificationservice.repo.ServiceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NotificationServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner run(ServiceRepo serviceRepo) {
    return args -> {
      serviceRepo.save(new Service(null, "/telegram", "Telegram", "Hello telegram", Status.SERVICE_AVAILABLE));
      serviceRepo.save(new Service(null, "/skype", "Skype", "Hello Skype", Status.SERVICE_AVAILABLE));
      serviceRepo.save(new Service(null, "/discord", "Discord", "Hello Discord", Status.SERVICE_NOTAVAILABLE));
      serviceRepo.save(new Service(null, "/webex", "Webex", "Hello webex", Status.SERVICE_NOTAVAILABLE));
    };
  }


}
