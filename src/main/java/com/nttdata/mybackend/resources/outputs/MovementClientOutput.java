package com.nttdata.mybackend.resources.outputs;

import java.util.Date;

import lombok.Data;

@Data
public class MovementClientOutput {
  private Date date;
  private String clientName;
  private String accountNumber;
  private String type;
  private float initialAmount;
  private Boolean state;
  private float movement;
  private float actualAmount;

  public MovementClientOutput(
    Date date,
    String clientName,
    String accountNumber,
    String type,
    float initialAmount,
    Boolean state,
    float movement,
    float actualAmount
  ) {
    this.date = date;
    this.clientName = clientName;
    this.accountNumber = accountNumber;
    this.type = type;
    this.initialAmount = initialAmount;
    this.state = state;
    this.movement = movement;
    this.actualAmount = actualAmount;
  }

}