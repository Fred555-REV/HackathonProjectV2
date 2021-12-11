package com.hackathon.responseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ResponseService {

    @Value("${ticketservice.path}")
    private String ticketPath;

    @Autowired
    private ResponseRepository repository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public List<Response> getResponsesFromUser(Long user_id) {
        return repository.findAllByUser_id(user_id);
    }

    public List<Response> getResponsesFromTicket(Long ticket_id) {
        return repository.findAllByTicket_id(ticket_id);
    }

    public Response addResponseToTicket(Long ticket_id, Response response) {
        response.setTicket_id(ticket_id);
        restTemplate().put(ticketPath + "/tickets/{id}", response, Map.of("id", ticket_id));
        return repository.save(response);
    }

    public Response editResponse(Long id, Response responseUpdate) {
        Response response = repository.getById(id);
        if (responseUpdate.getContent() != null)
            response.setContent(responseUpdate.getContent());
        repository.save(response);
        return repository.getById(id);
    }

    public List<Response> getAllResponses() {
        return repository.findAll();
    }

    public void deleteResponsesOfTicket(Long ticket_id) {
        repository.deleteResponsesByTicket_ID(ticket_id);
    }
}
