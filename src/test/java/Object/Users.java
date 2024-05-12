package Object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Users extends DataUsers {

    public static final Employees author_ApprovalCard = new Employees("Автор_КарточкаСогласования", "Смокин118", DataUsers.loginIniciator, DataUsers.passIniciator);
    public static final Employees approvingUser_1 = new Employees("Согласующий_1", "", "", "");
    public static final Employees negativeUser = new Employees("ПроверкаНегативнойАвторизации", "ПроверкаНегативнойАвторизации", DataUsers.loginNegativeUser, DataUsers.passNegativeUser);
}