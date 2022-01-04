package com.iba.notificationservice.service;

import com.iba.notificationservice.model.Service;

import java.util.Collection;

/**
 * @author Artur Marchanka
 */
public interface ServService {
  Service create(Service service);
  Service ping(String APIAddress);
  Collection<Service> list(int limit);
  Service get(Long id);
  Service update(Service service);
  Boolean delete(Long id);
}
