package com.hackathon.ticketservice.tickets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.ticketservice.responses.Response;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID referenceId = UUID.randomUUID();
    private Long userID;
    private String department;
    private String status;
    private String title;
    private String content;
    @OneToMany
    @JoinColumn(name="ticket_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"ticket"})// no need for self reference
    private Set<Response> responses;
}
