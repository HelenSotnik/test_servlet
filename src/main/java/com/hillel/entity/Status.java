package com.hillel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "statuses")
public class Status {
    @Id
    private int id;

    @Column(unique = true, nullable = false)
    private String alias;

    @Column(nullable = false)
    private String description;

    public Status() {
    }
}
