package managers;

public final class AuthManager {

    private static String token;
    private static String userId;

    private AuthManager() {
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        AuthManager.token = token;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        AuthManager.userId = userId;
    }

    public static void clear() {
        token = null;
        userId = null;
    }
}