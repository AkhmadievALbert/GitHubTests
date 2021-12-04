package ru.itis.entities;

/**
 * created: 30-10-2021 - 12:16
 * project: AutoTests
 *
 * @author Alba
 * @version v0.1
 */
public class AccountData {

    private String email;
    private String password;

    public AccountData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
