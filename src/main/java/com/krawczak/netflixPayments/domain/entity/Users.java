package com.krawczak.netflixPayments.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "users")
public class Users implements Serializable {

  @Id
  @NotEmpty
  @UniqueElements
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "email")
  private String email;

  @NotEmpty
  @Column(name = "password")
  private String password;

  @Column(name = "enabled")
  private int enabled;


  @OneToMany(mappedBy = "users")
  List<Authorities> authorities = new ArrayList<>();


  @OneToMany(mappedBy = "users")
  List<Payment> payments = new ArrayList<>();

  public Users() {
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

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

  public List<Authorities> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(
      List<Authorities> authorities) {
    this.authorities = authorities;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
