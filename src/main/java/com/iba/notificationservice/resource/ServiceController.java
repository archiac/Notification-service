package com.iba.notificationservice.resource;

import com.iba.notificationservice.model.Response;
import com.iba.notificationservice.service.implementation.ServServiceImplementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;


/**
 * @author Artur Marchanka
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
  private final ServServiceImplementation servServiceImplementation;

  public ServiceController(ServServiceImplementation servServiceImplementation) {
    this.servServiceImplementation = servServiceImplementation;
  }

  @GetMapping("list")
  public ResponseEntity<Response> getServices(){

    return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("services",servServiceImplementation.list(20)))
                    .message("Services retrieved")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
    );
  }
}
