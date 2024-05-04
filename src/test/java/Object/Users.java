package Object;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private String login;
    private String password;
    private String name;

    public Users(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public  String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }

    // Статическая коллекция для хранения всех пользователей.
    private static Map<String, Users> usersMap = new HashMap<>();

    // Статический блок для инициализации коллекции.
    static {
        usersMap.put("Смокин_1", new Users("Смокин_1", "Smoke_user118", ""));
        // Для добавления копируем UsersMap и создаем по подобию второго пользователя
    }

    // Метод для получения пользователя по имени.
    public static Users getUserByName(String name) {
        return usersMap.get(name);
    }
}