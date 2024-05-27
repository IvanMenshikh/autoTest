package Object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employees {

    private String name;
    private String surname;
    private String role;
    private String login;
    private String password;

    public Employees(String name, String surname, String role, String login, String password){
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.login = login;
        this.password = password;
    }
}
