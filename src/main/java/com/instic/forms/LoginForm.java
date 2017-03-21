package com.instic.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
public class LoginForm {
    @Size(min = 2, max = 30)
    private String login;

    @Size(min = 3)
    @NotNull
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
