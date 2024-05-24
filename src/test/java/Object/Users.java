package Object;

import lombok.Getter;

@Getter
public class Users {

    public static final Employees iniciator_ACard = new Employees("Автор_КарточкаСогласования", "Смокин118", DataUsers.loginIniciator, DataUsers.passIniciator);
    public static final Employees approvingUser_1 = new Employees("Согласующий_1", "", "", "");
    public static final Employees negativeUser = new Employees("ПроверкаНегативнойАвторизации", "ПроверкаНегативнойАвторизации", DataUsers.loginNegativeUser, DataUsers.passNegativeUser);
}