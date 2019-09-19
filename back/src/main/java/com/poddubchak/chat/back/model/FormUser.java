package com.poddubchak.chat.back.model;

public class FormUser {
    private String name;
    private String login;
    private String hashPassword;

    public FormUser() {
    }

    public FormUser(String name, String login, String hashPassword) {
        this.name = name;
        this.login = login;
        this.hashPassword = hashPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
