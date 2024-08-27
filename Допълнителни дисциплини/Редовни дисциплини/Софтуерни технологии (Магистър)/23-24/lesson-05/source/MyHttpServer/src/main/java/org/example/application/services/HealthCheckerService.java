package org.example.services;

import org.example.tags.Service;

@Service
public class HealthCheckerService {

    public String healthCheck() {
        return "It is working";
    }
}
