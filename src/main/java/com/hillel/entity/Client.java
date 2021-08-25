package com.hillel.entity;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String name;
    private String email;
    private Long phone;
    private String about;
    private int age;
}
