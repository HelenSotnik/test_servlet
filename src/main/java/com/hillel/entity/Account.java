package com.hillel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private int id;

    @Column(name = "client_id", nullable = false)
    private int clientId;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private double value;

    public Account() {
    }
}
