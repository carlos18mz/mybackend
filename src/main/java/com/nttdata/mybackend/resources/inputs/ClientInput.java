package com.nttdata.mybackend.resources.inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientInput {
  private String name;
  private Boolean genre;
  private Integer age;
  private String direction;
  private String phone;
  private String identification;
  private String password;
  private Boolean state;
}
