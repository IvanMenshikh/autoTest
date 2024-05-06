package Object;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
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

    // Статическая коллекция для хранения всех пользователей.
    private static Map<String, Users> usersMap = new HashMap<>();

    // Статический блок для инициализации коллекции.
    static {
        usersMap.put("Смокин_1", new Users("Смокин_1", "Smoke_user118", "Test123456"));
        usersMap.put("Смокин_2", new Users("Смокин_2", "", ""));// Для добавления копируем UsersMap и создаем по подобию первого пользователя
    }

    // Метод для получения пользователя по имени.
    public static Users getUserByName(String name) {
        return usersMap.get(name);
    }
}