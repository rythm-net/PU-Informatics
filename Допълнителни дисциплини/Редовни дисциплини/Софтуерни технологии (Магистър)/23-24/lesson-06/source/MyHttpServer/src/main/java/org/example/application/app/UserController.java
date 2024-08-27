package org.example.application.app;

import org.example.framework.server.types.ControllerView;
import org.example.application.services.HealthCheckerService;
import org.example.framework.tags.HttpController;
import org.example.framework.tags.HttpMethod;
import org.example.framework.tags.HttpParameterHash;

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
