package web.data;

public enum UserCredentials {
    STANDARD_USER("standard_user"),
    LOCKED_USER("locked_out_user");

    private final String username;

    UserCredentials(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

