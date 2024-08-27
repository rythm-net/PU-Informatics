package org.example.framework.server.contracts;

import java.util.HashMap;

public class HttpRequestObject {

    private String httpMethod;
    private String httpPath;

    private String httpQueryParameter;

    private HashMap<String, String> httpQueryHash;

    public HttpRequestObject(String httpMethod, String httpPath) {

        this.httpMethod = httpMethod;

        // users/page?id=10
        var pathCollection      = httpPath.split("\\?");
        this.httpPath           = pathCollection[0]; // users/page
        this.httpQueryParameter = (pathCollection.length > 1) ? pathCollection[1] : "";
        this.httpQueryHash      = this.processQueryHash();
    }

    public HttpRequestObject() {

    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getHttpPath() {
        return this.httpPath;
    }

    public HashMap getHttpQueryParameterHash() {
        return this.httpQueryHash;
    }

    public String getHttpQueryParameter(String key) {
        return this.httpQueryHash.get(key);
    }

    private HashMap<String, String> processQueryHash() {

        HashMap<String, String> queryMap = new HashMap<>();

        if(this.httpQueryParameter.isEmpty()) {
            return queryMap;
        }

        String[] keyValueCollection =  this.httpQueryParameter.split("&");

        for(String keyValueElement : keyValueCollection) {

            try {
                String[] keyValueSplit = keyValueElement.split("=");
                String queryKey = keyValueSplit[0];
                String queryValue = keyValueSplit[1];
                queryMap.put(queryKey, queryValue);
            }
            catch (IndexOutOfBoundsException e) {
                // TODO: Think
            }
        }

        return queryMap;
    }
}
