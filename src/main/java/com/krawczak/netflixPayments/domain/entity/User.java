package com.krawczak.netflixPayments.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "user")
public class User implements Serializable {

  @Id
  @NotEmpty
  @UniqueElements
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @NotEmpty
  @Column(name = "password")
  private String password;

  @Column(name = "active")
  private int active;


  @OneToMany(mappedBy = "user")
  List<Authorities> authorities = new ArrayList<>();


  @OneToMany(mappedBy = "user")
  List<Payment> payments = new ArrayList<>();

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String login) {
    this.username = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public List<Authorities> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(
      List<Authorities> authorities) {
    this.authorities = authorities;
  }
}
