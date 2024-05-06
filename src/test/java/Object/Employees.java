package Object;

import java.util.HashMap;
import java.util.Map;

public class Employees {

    // Статическая коллекция для хранения всех пользователей.
    private static Map<String, Users> usersMap = new HashMap<>();

    // Статический блок для инициализации коллекции.
    static {
        usersMap.put("Автор_КарточкиСогласования", new Users("Автор_КарточкиСогласования", "Smoke_user118", "Test123456"));
        usersMap.put("Согласующий_1", new Users("Согласующий_1", "", ""));// Для добавления копируем UsersMap и создаем по подобию первого пользователя
    }

    // Метод для получения пользователя по имени.
    public static Users getUserByName(String name) {
        return usersMap.get(name);
    }

}
