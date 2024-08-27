package org.example.framework.server.contracts;

public class HttpResponseObject {

    private final static String CRLF = "\r\n";
    private final static String CRLF2 = "\r\n\r\n";

    private int statusCode = 200;
    private String statusMessage = "Success";

    private String responseBody = "";

    private String contentType = "text/html";

    public void setStatusCode(HttpStatusCodeEnum statusCode) {
        this.statusCode = statusCode.getValue();
    }

    public void setStatusMessage(String message) {
        this.statusMessage = message;
    }

    public void setContentType(HttpContentTypeEnum contentType) {
        this.contentType = contentType.getValue();
    }

    public void setResponseBody(String body) {
        this.responseBody = body;
    }

    public String getHttpMessage() {

        return this.getHttpHeader()  + CRLF +
                "Content-Length: " + this.responseBody.getBytes().length + CRLF +
                "Content-Type: " + this.contentType + CRLF2 +
                this.responseBody + CRLF2;
    }

    private String getHttpHeader() {
        return "HTTP/1.1 " + this.statusCode + " " + this.statusMessage;
    }





//
//            return "HTTP/1.1 " + statusCode + " " + statusMessage + CRLF +
//            "Access-Control-Allow-Origin: *" + CRLF +
//            "Content-Length: " + httpResponseBody.getBytes().length + CRLF +
//            "Content-Type: text/html" + CRLF + CRLF +
//    httpResponseBody        + CRLF + CRLF;

}
