package Object;

import lombok.Getter;

@Getter
public class Users {

    public static final Employees iniciator_ACard = new Employees("Александр", "Смокин118", "ИнициаторКС", DataUsers.loginIniciator, DataUsers.passIniciator);
    public static final Employees approvingUser_1 = new Employees("", "", "Согласующий_1", "", "");
    public static final Employees negativeUser = new Employees("Проверка_negAuth", "Проверка_negAuth", "Проверка_negAuth", DataUsers.loginNegativeUser, DataUsers.passNegativeUser);
}