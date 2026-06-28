package managers;

import pojo.login.LoginResponse;
import services.LoginService;
public final class AuthenticationManager {

    private AuthenticationManager() {
    }

    public static String getToken() {

        if (AuthManager.getToken() == null) {

            System.out.println("Token is null. Calling Login API...");

            LoginResponse response = new LoginService().login();

            AuthManager.setToken(response.getToken());
            AuthManager.setUserId(response.getUserId());
        }

        System.out.println("Returning Token = " + AuthManager.getToken());

        return AuthManager.getToken();
    }
}