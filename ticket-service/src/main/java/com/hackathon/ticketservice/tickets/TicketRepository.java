package com.hackathon.ticketservice.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t where t.status = :status")
    List<Ticket> getAllActiveTickets(String status);

    @Query("SELECT t FROM Ticket t where t.userID = :userID")
    List<Ticket> getAllTicketsByUser(@Param("userID") Long userID);
}
