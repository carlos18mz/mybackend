package com.nttdata.mybackend.resources.outputs;

import lombok.Data;

@Data
public class AccountOutput {
  private String accountNumber;
  private String accountType;
  private float amount;
  private Boolean state;
  private String clientName;

  public AccountOutput( 
    String accountNumber,
    String accountType,
    float amount,
    Boolean state,
    String clientName) {
      this.accountNumber = accountNumber;
      this.accountType = accountType;
      this.amount = amount;
      this.state = state;
      this.clientName = clientName;
   }
}
