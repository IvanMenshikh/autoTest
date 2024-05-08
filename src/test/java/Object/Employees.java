package Object;

import lombok.Getter;
@Getter
public class Employees {

    private String name;
    private String surename;
    private String login;
    private String password;

    public Employees(String name, String surename, String login, String password){
        this.name = name;
        this.surename = surename;
        this.login = login;
        this.password = password;
    }
}
