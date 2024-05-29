package StartTest.ApprovalCard;

import Helper.*;
import Object.Users;
import StartTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class C_1_001 extends BaseTest {


    @Test
    public void startTest(){

        ConstructorApprovalCardHelper constructorApprovalCardHelper = new ConstructorApprovalCardHelper();
        AuthHelper authHelper = new AuthHelper();
        MainHelper mainHelper = new MainHelper();
        AtributeDocHelper atributeDocHelper = new AtributeDocHelper();
        BlackBarHelper blackBarHelper = new BlackBarHelper();

        //Step 1 - Негативная авторизация.
        authHelper.CheckNegativeLogIn(Users.negativeUser);

        // Step 2 - Авторизация.
        authHelper.authorization(Users.iniciator_ACard);

        // Step 3 - Деавторизация пользователем и повторная авторизация под новым пользователем. (в нашем случае тем же самым)
        authHelper.LogOutAndNewAuth(Users.iniciator_ACard);

        // Step 3 - Создать -> Карточка согласования.
        mainHelper.createDoc("Карточка согласования");

        // Step 4 - Проверка созданного документа. Подтверждаем, что это Карточка согласования.
        constructorApprovalCardHelper.checkApprovalCard();

        // Step 5 - Выбираем вид Карточки согласования.
        constructorApprovalCardHelper.selectDocType();

        // Step 6 - Заполняем поле - "Заголовок".
        constructorApprovalCardHelper.writeTitle_ApprovalCard("Тестовый документ. Меньших И.А.");

        // Step 7 - Выбираем категорию документа.
        atributeDocHelper.docCategory("Открытый");

        // Step 8 - Загружаем вложение. (На форме создания)
        atributeDocHelper.downloadAttachmen();

        // Step 9 - Создаем маршрут согласования. (Индивидуальный)
        constructorApprovalCardHelper.createApprovalRoute();

        // Step 10 - Сохраняем проект документа.
        atributeDocHelper.createProjectDoc();

        // Step 11 - Проверяем, что документ создан.
        constructorApprovalCardHelper.checkAtributeNewDoc();

        // Step 12 - Переходим из документа на главную страницу АРМ СЭД.
        blackBarHelper.clickOnKsed();

        // Step 13 - Переключаемся на нужный нам блок. Проверяем что открыт нужный нам блок.
        mainHelper.selectBlock("Моя работа");
        mainHelper.checkBlockMyJob("Исполнить поручения", "Согласовать", "Созданные мной документы");

        // Step 14 - Открываем узел в блоке, првоеряем, что узел открыт.
        mainHelper.node_SelectNode("Созданные мной документы");
        mainHelper.node_CheckAtributeNode("Фильтры", "Действия с выбранными", "Столбцы");

        Selenide.sleep(5000);
    }
}