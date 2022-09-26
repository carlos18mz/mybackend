package com.nttdata.mybackend.resources.outputs;

import lombok.Data;

@Data
public class ClientOutput {
  private String name;
  private String direction;
  private String phone;
  private String password;
  private Boolean state;
  
  public ClientOutput(String name, String direction, String phone, String password, Boolean state) {
    this.name = name;
    this.direction = direction;
    this.phone = phone;
    this.password = password;
    this.state = state;
  }
}
