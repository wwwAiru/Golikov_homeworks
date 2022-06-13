package com.company.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance;


    @OneToOne(mappedBy = "account", cascade = {CascadeType.MERGE,
                                               CascadeType.PERSIST,
                                               CascadeType.DETACH,
                                               CascadeType.REFRESH})
    private Client client;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
