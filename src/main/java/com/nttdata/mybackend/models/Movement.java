package com.nttdata.mybackend.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Entity
@Table(name = "movements")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Movement implements Serializable {

  @Getter(AccessLevel.PRIVATE)
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  
  @CreatedDate
  @Column(name = "date", nullable = false)
  public Date date;

  @Column(name = "type")
  public String type;
  
  @Column(name = "value")
  public float value;

  @Column(name = "amount")
  public float amount;

  @ManyToOne()
  @JoinColumn(name = "account_id")
  Account account;

  public Movement(Date date, String type, float value, float amount) {
    this.date = date;
    this.type = type;
    this.value = value;
    this.amount = amount;
  }

}
