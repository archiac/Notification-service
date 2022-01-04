package com.iba.notificationservice.enumeration;

/**
 * @author Artur Marchanka
 */
public enum Status {
  SERVICE_AVAILABLE("SERVICE_AVAILABLE"),
  SERVICE_NOTAVAILABLE("SERVICE_NOTAVAILABLE");
  private final String status;

  Status(String status){
    this.status=status;
  }

  public String getStatus() {
    return this.status;
  }
}
