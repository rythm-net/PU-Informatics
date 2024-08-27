package org.example.server.contracts;

public enum HttpContentTypeEnum {

    TEXT_HTML("text/html"),
    JSON("application/json");

    private String value;

    HttpContentTypeEnum(String contentType) {
        this.value = contentType;
    }

    public String getValue() {
        return this.value;
    }
}
