package Object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employees {

    private String name;
    private String surname;
    private String login;
    private String password;

    public Employees(String name, String surname, String login, String password){
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
}
