package com.unionOfMiners.android.union.auth;

/**
 * Created by HP on 26.09.2017.
 */

public class AuthBody {

    public String login;
    public String password;

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
