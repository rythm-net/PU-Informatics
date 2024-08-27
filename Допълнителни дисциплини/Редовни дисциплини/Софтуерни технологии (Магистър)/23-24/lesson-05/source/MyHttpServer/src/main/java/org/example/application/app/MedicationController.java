package org.example.app;

import org.example.models.Medication;
import org.example.services.MedicationService;
import org.example.tags.HttpController;
import org.example.server.types.ControllerJsonResponse;
import org.example.tags.HttpMethod;

import java.util.ArrayList;

@HttpController
public class MedicationController {

    MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @HttpMethod(path = "/medication")
    public ControllerJsonResponse getAll() {

        ArrayList<Medication> collection = this.medicationService.getAll();
        return new ControllerJsonResponse(collection);
    }
}
