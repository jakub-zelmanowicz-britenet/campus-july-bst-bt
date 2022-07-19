package pl.britenet.campus.object;

import pl.britenet.campus.Constants;

public class User {

    private final int id;
    private String username;
    private String password;

    public User() {
        this.id = Constants.INVALID_ID;
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
