package com.krawczak.netflixPayments.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @Column(name = "authority")
    String authority;

    @OneToMany(mappedBy = "authority")
    List<Authorities> authorities = new ArrayList<>();

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
