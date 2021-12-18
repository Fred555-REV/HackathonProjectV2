package com.hackathon.ticketservice.tickets;

import com.hackathon.ticketservice.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    public TicketService service;

    @GetMapping
    public List<Ticket> getTickets() {
        return service.getTickets();
    }

    @GetMapping("/active")
    public List<Ticket> getActiveTickets() {
        return service.getActiveTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return service.getTicketByID(id);
    }

    @GetMapping("/user/{userID}")
    public List<Ticket> getTicketsByUser(@PathVariable Long userID) {
        return service.geticketsByUser(userID);
    }

    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return service.addTicket(ticket);
    }

    @PostMapping("/{id}")
    public Ticket addResponse(@PathVariable Long id, @RequestBody Response response) {
        return service.addResponse(id,response);
    }

//TODO send a request to response service with ticket_id

//create response in response service
    //send it to ticket to add it

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id,
                               @RequestBody Ticket ticket){
        return service.updateTicket(id,ticket);
    }
}
