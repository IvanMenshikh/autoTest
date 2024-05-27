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

        //Step 1 - Негативная авторизация.
        authHelper.CheckNegativeLogIn(Users.negativeUser);

        // Step ? - Деавторизация текущим пользователем.
        //authHelper.logOut();

        // Step 2 - Авторизация.
        authHelper.authorization(Users.iniciator_ACard);

        // Step 3 - Деавторизация пользователем и повторная авторизация под новым пользователем. (в нашем случае тем же самым)
        authHelper.LogOutAndNewAuth(Users.iniciator_ACard);

        // Step 3 - Создать -> Карточка согласования.
        //mainPage.createDoc("Карточка согласования");

        // Step 4 - Проверка созданного документа. Подтверждаем, что это Карточка согласования.
        //constructorApprovalCard.checkApprovalCard();

        // Step 5 - Выбираем вид Карточки согласования.
        //constructorApprovalCard.selectDocType();

        // Step 6 - Заполняем поле - "Заголовок".
        //constructorApprovalCard.writeTitle_ApprovalCard("Тестовый документ. Меньших И.А.");

        // Step 7 - Выбираем категорию документа.
        //atributeDocHelper.docCategory("Открытый");

        // Step 8 - Загружаем вложение. (На форме создания)
        //atributeDocHelper.downloadAttachmen();


        // Step 9 - Создаем маршрут согласования. (Индивидуальный)
        //constructorApprovalCard.createApprovalRoute();

        // Step 10 - Сохраняем проект документа.
        //constructorApprovalCard.createProjectDoc();
    }

}