package org.example.application.services;

import org.example.framework.tags.Service;

@Service
public class HealthCheckerService {

    public String healthCheck() {
        return "It is working";
    }
}
