package org.example.application;

@Controller
public class UserController {

    @Method(action = "GET", path = "/users")
    public String getUserData() {
        return "<h1>USERS endpoint</h1>";
    }

    @Method(action = "GET", path = "/test")
    public String getUserJson() {
        return "<h1>TEST endpoint</h1>";
    }

    @Method(action = "GET", path = "/mests")
    public String postUserData() {
        return "<h1>MEST endpoint</h1>";
    }
}
