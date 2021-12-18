package com.hackathon.responseservice;

import java.util.Set;

public class Ticket {
    private Set<Response> responses;

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }
}
