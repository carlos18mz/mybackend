package com.nttdata.mybackend.resources.inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountInput {
  private String accountNumber;
  private String accountType;  
  private float initialAmount;
  private Boolean state;
}
