package org.example.app;

import org.example.tags.HttpController;
import org.example.tags.HttpMethod;

@HttpController
public class UserController {

    @HttpMethod(path = "/users/page")
    public String getUserPage() {
        return "<div class='card'>" +
                "<ul>" +
                "<li>Mihail Petrov</li>" +
                "<li>Ivan Ivanov</li>" +
                "</ul>" +
                "</div>";
    }

    @HttpMethod(path = "/users/balance")
    public String getUserBalance() {
        return "<div>500</div>";
    }
}
