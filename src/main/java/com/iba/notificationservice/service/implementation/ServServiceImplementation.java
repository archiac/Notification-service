package com.iba.notificationservice.service.implementation;

import com.iba.notificationservice.model.Service;
import com.iba.notificationservice.repo.ServiceRepo;
import com.iba.notificationservice.service.ServService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.logging.Logger;

import static org.springframework.data.domain.PageRequest.of;

/**
 * @author Artur Marchanka
 */

@org.springframework.stereotype.Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ServServiceImplementation implements ServService {

  private final ServiceRepo serviceRepo;

  @Override
  public Service create(Service service) {
    log.info("Saving new service: {}", service.getName());
    return serviceRepo.save(service);
  }

  @Override
  public Service ping(String APIAddress) {
    return null;
  }

  @Override
  public Collection<Service> list(int limit) {
    log.info("Fetching all services");
    return serviceRepo.findAll(of(0, limit)).toList();
  }

  @Override
  public Service get(Long id) {
    log.info("Fetching service by id: {}", id);
    return serviceRepo.getById(id);
  }

  @Override
  public Service update(Service service) {
    log.info("Updating new service: {}", service.getName());
    return serviceRepo.save(service);
  }

  @Override
  public Boolean delete(Long id) {
    log.info("Deleting service by id: {}", id);
    serviceRepo.deleteById(id);
    return true;
  }
}
