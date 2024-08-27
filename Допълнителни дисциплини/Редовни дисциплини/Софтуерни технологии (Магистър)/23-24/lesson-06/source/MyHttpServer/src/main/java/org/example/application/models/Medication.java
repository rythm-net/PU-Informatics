package org.example.application.models;

import org.example.framework.tags.CustomEntity;

@CustomEntity(table = "medications")
public class Medication {

    public int id;
    public String title;
    public String description;

}
