package com.nttdata.mybackend.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Entity
//@Table(name = "clients")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Client extends Person {
  
  @Getter(AccessLevel.PRIVATE)
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "password")
  private String password;

  @Column(name = "state")
  private Boolean state;

  @OneToMany(mappedBy = "client")
  private List<Account> accounts = new ArrayList<>();

  public Client(String name, Boolean genre, Integer age, String direction, String phone, String identification, String password, Boolean state) {
    super(name, genre, age, direction, phone, identification);
    this.password = password;
    this.state = state;
  }
}
