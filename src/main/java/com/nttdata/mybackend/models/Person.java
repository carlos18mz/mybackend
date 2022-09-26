package com.nttdata.mybackend.models;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.*;

@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Person implements Serializable {

  @Getter(AccessLevel.PRIVATE)
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "genre", nullable = true)
  private Boolean genre;

  @Column(name = "age", nullable = true)
  private Integer age;

  @Column(name = "direction")
  private String direction;

  @Column(name = "phone")
  private String phone;

  @Column(name = "identification")
  private String identification;

  public Person(String name, Boolean genre, Integer age, String direction, String phone, String identification) {
    this.name = name;
    this.genre = genre;
    this.age = age;
    this.direction = direction;
    this.phone = phone;
    this.identification = identification;
  }

}
