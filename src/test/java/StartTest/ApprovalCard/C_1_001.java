package StartTest.ApprovalCard;

import Helper.AtributeDocHelper;
import Helper.AuthHelper;
import Helper.ConstructorApprovalCard;
import Object.Users;
import Page.LoginPage;
import Page.MainPage;
import StartTest.BaseTest;

import org.testng.annotations.Test;

public class C_1_001 extends BaseTest {


    @Test
    public void startTest(){

        ConstructorApprovalCard constructorApprovalCard = new ConstructorApprovalCard();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        AuthHelper authHelper = new AuthHelper();
        AtributeDocHelper atributeDocHelper = new AtributeDocHelper();

        // Step ? - Негативная авторизация.
        //loginPage.negativeAuthorization(Users.negativeUser);

        // Step ? - Деавторизация текущим пользователем.
        //authHelper.logOut();

        // Step 1 - Авторизация.
        authHelper.authorization(Users.iniciator_ACard);

        // Step 2 - Создать -> Карточка согласования.
        mainPage.createDoc("Карточка согласования");

        // Step 3 - Проверка созданного документа. Подтверждаем, что это Карточка согласования.
        constructorApprovalCard.checkApprovalCard();

        // Step 4 - Выбираем вид Карточки согласования.
        constructorApprovalCard.selectDocType();

        // Step 5 - Заполняем поле - "Заголовок".
        constructorApprovalCard.writeTitle_ApprovalCard("Тестовый документ. Меньших И.А.");

        // Step 6 - Выбираем категорию документа.
        atributeDocHelper.docCategory("Открытый");

        // Step 7 - Загружаем вложение. (На форме создания)
        atributeDocHelper.downloadAttachmen();


        // Step 8 - Создаем маршрут согласования. (Индивидуальный)
        constructorApprovalCard.createApprovalRoute();

        // Step 9 - Сохраняем проект документа.
        //constructorApprovalCard.createProjectDoc();
    }

}