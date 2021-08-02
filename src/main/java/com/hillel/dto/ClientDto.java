package com.hillel.dto;

import lombok.Data;

@Data
public class ClientDto {
    private int id;
    private String name;
    private String email;
    private Long phone;
    private String about;
    private int age;
}
