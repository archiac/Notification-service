package com.iba.notificationservice.model;

import com.iba.notificationservice.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Artur Marchanka
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String APIAddress;
  private String name;
  private String message;
  private Status status;
}
