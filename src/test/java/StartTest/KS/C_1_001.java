package StartTest.KS;

import Helper.*;
import Object.Users;
import StartTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class C_1_001 extends BaseTest {


    @Test
    public void startTest(){

        AuthHelper authHelper = new AuthHelper();
        MainHelper mainHelper = new MainHelper();
        CreationDocHelper creationDocHelper = new CreationDocHelper(); // ?
        BlackBarHelper blackBarHelper = new BlackBarHelper();
        CategoryDocHelper categoryDocHelper = new CategoryDocHelper();
        DocTypeHelper docTypeHelper = new DocTypeHelper();
        ApprovalRouteHelper approvalRouteHelper = new ApprovalRouteHelper();
        AttachmenHelper attachmenHelper = new AttachmenHelper();
        docHelper docHelper = new docHelper();

        // Step 1 - Негативная авторизация.
        // Живая авторизация.
        // Деавторизация и повторная авторизация.
        //authHelper.CheckNegativeLogIn(Users.negativeUser);
        authHelper.authorization(Users.iniciator_ACard);
        //authHelper.LogOutAndNewAuth(Users.iniciator_ACard);

        // Step 2 - Создаем выбранный тип документа, проверяем на соответсвие.
        mainHelper.createDoc("Карточка согласования");
        creationDocHelper.checkApprovalCard();

        // Step 3 - Выбираем вид КС.
        docTypeHelper.docType("Прочие", "Акт");

        // Step 4 - Заполняем поле - "Заголовок".
        creationDocHelper.writeTitle_ApprovalCard("Тестовый документ. Меньших И.А.");

        // Step 5 - Выбираем категорию документа.
        categoryDocHelper.docCategory("Открытый");

        // Step 6 - Загружаем вложение. (На форме создания)
        //attachmenHelper.downloadAttachmen();

        // Step 7 - Создаем маршрут согласования. (route - Индивидуальный; stage - Согласование КС)
        //approvalRouteHelper.createApprovalRoute("Индивидуальный");
        //approvalRouteHelper.createApprovalStage("Согласование КС");

        // Step 8 - Сохраняем проект документа.
        creationDocHelper.createProjectDoc();

        // Step 9 - Проверяем, что документ создан. Выполняем переход на MainPage страницу
        try {
            docHelper.checkLoadDoc();
        } catch (Throwable e){
            e.printStackTrace();
        }
        blackBarHelper.clickOnKsed();

        // Step 10 - Переключаемся на нужный нам блок. Проверяем что открыт нужный нам блок. Открываем узел в блоке, првоеряем, что узел открыт.
        mainHelper.selectBlock("Моя работа");
        mainHelper.checkBlockMyJob("Исполнить поручения", "Согласовать", "Созданные мной документы");
        mainHelper.node_SelectNode("Созданные мной документы");
        mainHelper.node_CheckAtributeNode("Фильтры", "Действия с выбранными", "Столбцы");

        Selenide.sleep(5000);
    }
}