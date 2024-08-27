package org.example.app;

import org.example.server.types.ControllerView;
import org.example.services.HealthCheckerService;
import org.example.tags.HttpController;
import org.example.tags.HttpMethod;
import org.example.tags.HttpParameterHash;

import java.util.HashMap;

@HttpController
public class UserController {

    private HealthCheckerService healthCheckerService;

    public UserController(HealthCheckerService healthCheckerService) {
        this.healthCheckerService = healthCheckerService;
    }

    @HttpMethod(path = "/users/page")
    public String getUserPage(@HttpParameterHash HashMap queryCollection) {
        return "user_page";
    }

    @HttpMethod(path = "/users/account")
    public ControllerView getUserAccount(@HttpParameterHash HashMap queryCollection) {
        return new ControllerView("user_account");
    }

    @HttpMethod(path="/user/health")
    public String getHealth() {
        System.out.println(
                this.healthCheckerService.healthCheck()
        );
        return "user_health";
    }


    @HttpMethod(path = "/users/balance")
    public String getUserBalance() {
        return "<div>500</div>";
    }
}
