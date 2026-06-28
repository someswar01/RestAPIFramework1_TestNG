package managers;

import pojo.login.LoginResponse;
import services.LoginService;

public final class TokenManager {

    private static String token;
    private static String userId;

    private TokenManager() {
    }

    public static String getToken() {

        if (token == null || token.isBlank()) {

            LoginResponse response = new LoginService().login();

            token = response.getToken();
            userId = response.getUserId();

            System.out.println("New Token Generated");
        }

        return token;
    }

    public static String getUserId() {

        if (userId == null || userId.isBlank()) {

            getToken();
        }

        return userId;
    }

    /**
     * Clears cached authentication.
     * Useful for logout scenarios or forcing a fresh login.
     */
    public static void clearToken() {

        token = null;
        userId = null;
    }
}