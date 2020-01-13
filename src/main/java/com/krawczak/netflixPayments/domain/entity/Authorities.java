package com.krawczak.netflixPayments.domain.entity;

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

@Entity
@Table(name = "authorities")
public class Authorities {

  @Id
  @Column(name = "authority")
  private String authority;

  @ManyToOne
  @JoinColumn(name = "username")
  private User user;

  public Authorities() {
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

}
