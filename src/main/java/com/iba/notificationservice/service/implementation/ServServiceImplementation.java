package com.iba.notificationservice.service.implementation;

import com.iba.notificationservice.model.Service;
import com.iba.notificationservice.repo.ServiceRepo;
import com.iba.notificationservice.service.ServService;
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
public class ServServiceImplementation implements ServService {


  private final ServiceRepo serviceRepo;

  public ServServiceImplementation(ServiceRepo serviceRepo) {
    this.serviceRepo = serviceRepo;
  }

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
    return null;
  }

  @Override
  public Service update(Service service) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
}
