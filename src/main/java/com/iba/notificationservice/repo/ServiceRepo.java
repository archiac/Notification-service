package com.iba.notificationservice.repo;

import com.iba.notificationservice.model.Service;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Artur Marchanka
 */
public interface ServiceRepo extends JpaRepository<Service,Long> {
  Service findByAPIAddress(String APIAddress);
}
