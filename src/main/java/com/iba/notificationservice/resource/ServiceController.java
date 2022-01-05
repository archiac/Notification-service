package com.iba.notificationservice.resource;

import com.iba.notificationservice.model.Response;
import com.iba.notificationservice.model.Service;
import com.iba.notificationservice.service.implementation.ServServiceImplementation;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


/**
 * @author Artur Marchanka
 */
@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class ServiceController {

  private final ServServiceImplementation servServiceImplementation;

  @GetMapping("/list")
  public ResponseEntity<Response> getServices() {
    return ResponseEntity.ok(
      Response.builder()
        .timeStamp(LocalDateTime.now())
        .data(Map.of("services", servServiceImplementation.list(20)))
        .message("Services retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }

  @PostMapping("/save")
  public ResponseEntity<Response> saveService(@RequestBody Service service) {
    return ResponseEntity.ok(
      Response.builder()
        .timeStamp(LocalDateTime.now())
        .data(Map.of("service", servServiceImplementation.create(service)))
        .message("Service saved")
        .status(CREATED)
        .statusCode(CREATED.value())
        .build()
    );
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Response> getService(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
      Response.builder()
        .timeStamp(LocalDateTime.now())
        .data(Map.of("service", servServiceImplementation.get(id)))
        .message("Service retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Response> deleteService(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
      Response.builder()
        .timeStamp(LocalDateTime.now())
        .data(Map.of("deleted", servServiceImplementation.delete(id)))
        .message("Service deleted")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }

}
