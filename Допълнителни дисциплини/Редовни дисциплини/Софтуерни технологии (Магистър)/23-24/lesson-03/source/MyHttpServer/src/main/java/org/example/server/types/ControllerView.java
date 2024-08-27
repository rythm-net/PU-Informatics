package org.example.server.types;


import java.util.HashMap;

public class ControllerView {

    private String htmlTemlateString;
    private HashMap templateParameters;

    public ControllerView(String htmlTemlateString) {
        this.htmlTemlateString = htmlTemlateString;
    }

    public ControllerView(String htmlTemlateString, HashMap templateParameters) {
        this.htmlTemlateString = htmlTemlateString;
        this.templateParameters = templateParameters;
    }

    public String getStringId() {
        return this.htmlTemlateString;
    }
}
