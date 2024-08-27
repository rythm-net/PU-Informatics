package org.example.application.app;

import org.example.application.models.Medication;
import org.example.application.services.MedicationService;
import org.example.framework.tags.HttpController;
import org.example.framework.server.types.ControllerJsonResponse;
import org.example.framework.tags.HttpMethod;

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
