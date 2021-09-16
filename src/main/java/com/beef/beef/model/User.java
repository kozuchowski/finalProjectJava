package com.beef.beef.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@DiscriminatorColumn(name="role")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String login;

    private String password;

}