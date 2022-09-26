package com.nttdata.mybackend.resources.outputs;

import lombok.Data;

@Data
public class MovementOutput {
  private String accountNumber;
  private String accoutType;
  private float amount;
  private Boolean state;
  private String movement;

  public MovementOutput(
    String accountNumber,
    String accoutType,
    float amount,
    Boolean state,
    String movement
  ) {
    this.accountNumber = accountNumber;
    this.accoutType = accoutType;
    this.amount = amount;
    this.state = state;
    this.movement = movement;
  } 
}
