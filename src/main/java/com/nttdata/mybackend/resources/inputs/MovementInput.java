package com.nttdata.mybackend.resources.inputs;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovementInput {
  private Date date;
  private String type;
  private float value;
  private float amount;
}
