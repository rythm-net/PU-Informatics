package org.example.services;

import org.example.models.Medication;
import org.example.tags.Service;

import java.util.ArrayList;

@Service
public class MedicationService {

    public ArrayList<Medication> getAll() {

        ArrayList<Medication> collection = new ArrayList<>();
        collection.add(new Medication(){{
            id = 1;
            title = "Medication 1";
            description = "Medication Description 1";
        }});

        collection.add(new Medication(){{
            id = 2;
            title = "Super Med";
            description = "Extra healthy";
        }});

        return collection;
    }
}
