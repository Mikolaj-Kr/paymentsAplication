package com.krawczak.netflixPayments.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {

  @Id
  @Column(name = "authority")
  private String authority;

  @ManyToOne
  @JoinColumn(name = "username")
  private Users users;

  public Authorities() {
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Users getUsers() {
    return users;
  }

}
