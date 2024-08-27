package org.example.framework.server.types;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ControllerJsonResponse<T> implements IResponseType {

    private ArrayList<T> parseCollection;

    public ControllerJsonResponse(ArrayList<T> collection) {
        this.parseCollection = collection;
    }

    private String parseObjectToJson() throws IllegalAccessException {

        // [
        //  { "id": 1, "title": "Medication", "description": "Test"},
        //  { "id": 2, "title": "Medication 2", "description": "Test 2"}
        // ]


        ArrayList<String> jsonObjectCollection = new ArrayList<>();

        for(var element: this.parseCollection) {

            Field[] fieldCollection = element.getClass().getFields();
            ArrayList<String> jsonPair = new ArrayList<>();

            for(var objectElement : fieldCollection) {

                var fieldName = objectElement.getName();

                jsonPair.add(
                        "\"" + objectElement.getName() + "\":" +
                                "\"" +    objectElement.get(element) + "\""
                );
            }

            String jsonObjectElement = "{" +
                        String.join(",", jsonPair) +
                    "}";

            jsonObjectCollection.add(jsonObjectElement);
        }

        return "[" +
                String.join(",", jsonObjectCollection) +
                "]";
    }

    @Override
    public String getTypeResult() {
        try {
            return parseObjectToJson();
        }
        catch (IllegalAccessException e) {
            return "[{}]";
        }
    }
}
