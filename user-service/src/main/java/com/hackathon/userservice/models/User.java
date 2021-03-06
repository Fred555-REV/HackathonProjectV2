package com.hackathon.userservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String departments; // general | back | front | both
}
