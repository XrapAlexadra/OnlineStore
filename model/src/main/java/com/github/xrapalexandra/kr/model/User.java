package com.github.xrapalexandra.kr.model;


import java.util.Objects;

public class User {

    private Integer Id;
    private String login;
    private String pass;
    private Role role;

    public User() {
    }

    public User(String login, Role role, String pass) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + Id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id.equals(user.Id) &&
                login.equals(user.login) &&
                pass.equals(user.pass) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
