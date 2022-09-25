package com.nttdata.mybackend.models;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Account implements Serializable {

  @Getter(AccessLevel.PRIVATE)
  private static final long serialVersionUID = 1L;

  @Id  
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name="account_number")
  private String accountNumber;

  @Column(name="account_type")
  private String accountType;

  @Column(name="initial_amount")
  private float initialAmount;

  @Column(name="state")
  private Boolean state;

  public Account(String accountNumber, String accountType, float initialAmount, Boolean state) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.initialAmount = initialAmount;
    this.state = state;
  }
}
