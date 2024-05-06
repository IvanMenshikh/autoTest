package Object;

import lombok.Getter;
@Getter
public class Users {

    private String login;
    private String password;
    private String name;


    public Users(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
}