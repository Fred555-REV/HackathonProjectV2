package com.hackathon.ticketservice;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Long id;
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String departments; // general | back | front | both
  private String[] roles;
//  private Integer issuesHandled;
}
