package StartTest.KS;

import Helper.*;
import Object.Users;
import StartTest.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class C_1_001 extends BaseTest {


    @Test
    public void startTest(){

        AuthHelper authHelper = new AuthHelper(); // Хелпер авторизации.
        MainHelper mainHelper = new MainHelper(); // Хелпер главной страницы КСЭД.
        CreationDocHelper creationDocHelper = new CreationDocHelper(); // Хелпер формы создания документа.
        BlackBarHelper blackBarHelper = new BlackBarHelper(); // Хелпер черной полосы. (маршрутизатор по КСЭД)
        CategoryDocHelper categoryDocHelper = new CategoryDocHelper(); // Хелпер категории документов.
        DocTypeHelper docTypeHelper = new DocTypeHelper(); // Хедпер видов документов.
        ApprovalRouteHelper approvalRouteHelper = new ApprovalRouteHelper(); // Хелпер маршрутов согласования.
        AttachmenHelper attachmenHelper = new AttachmenHelper(); // Хелпер по вложениями.
        docHelper docHelper = new docHelper(); // Хелпер страницы проекта документа.
        FormEditDocHelper formEditDocHelper = new FormEditDocHelper(); // Хелпер формы редактирования атрибутов документа.
        BlockMyJobHelper blockMyJobHelper = new BlockMyJobHelper(); // Хелпер блока "Моя работа".
        ActionPanelHelper actionPanelHelper = new ActionPanelHelper(); // Хелпер панели действий документа.
        BannerHelper bannerHelper = new BannerHelper(); // Хелпер баннеров.

        //
        // Дополнительные методы, не включены в сценарий!
        //
        // Описание методов:
        // 1. Негативная авторизация.
        // 2. Деавторизация с повторной авторизацией.
        // 3. Загрузка вложения на форме создания.
        // 4. Создание маршрута согласования с этапом. route - Индивидуальный; stage - Согласование КС
        // 5. Проверка узлов в блоке "Моя работа".
        // 6. Проверка атрибуты открытого узла\подузла.
        // 7. Открыть узел, без подузлов.
        //
        // Методы по порядку из перечня:
        // authHelper.CheckNegativeLogIn(Users.negativeUser);
        // authHelper.LogOutAndNewAuth(Users.iniciator_ACard);
        // attachmenHelper.downloadAttachmen();
        // approvalRouteHelper.createApprovalRoute("Индивидуальный");
        // approvalRouteHelper.createApprovalStage("Согласование КС");
        // blockMyJobHelper.checkNodeInTheBlockMyJob("Созданные мной документы", "Согласовать", "Исполнить поручения");
        // blockMyJobHelper.node_CheckAtributeNode("Фильтры", "Действия с выбранными", "Столбцы");
        // blockMyJobHelper.node_SelectNode("Созданные мной документы");


        // Step 1 - Негативная авторизация; Авторизация под пользователем; Деавторизация и повторная авторизация.
        authHelper.authorization(Users.iniciator_ACard);

        // Step 2 - Создаем выбранный тип документа, проверяем на соответсвие.
        mainHelper.createDoc("Карточка согласования");
        creationDocHelper.checkApprovalCard();

        // Step 3 - Выбираем вид КС. Заполняем заголовок. Выбираем категорию и вид документа. Проверяем на соответствие.
        docTypeHelper.docType("Прочие", "Акт");
        creationDocHelper.writeTitle_ApprovalCard("Тестовый документ. Меньших И.А.");
        categoryDocHelper.docCategory("Открытый");
        creationDocHelper.CheckCompletedFields("Акт", "Открытый");

        // Step 4 - Сохраняем проект документа. Проверяем атрибуты документа. Сохраняем номер документа в переменную, пригодится далее...
        creationDocHelper.createProjectDoc();
        docHelper.checkLoadDoc("Открытый", "Акт", "Проект");
        String docNumber = docHelper.getDocRegNumber();

        // Step 5 - Выполняем переход на MainPage страницу. Открываем блок "Моя работа". Открываем узел. Открываем подузел.
        blackBarHelper.clickOnKsed();
        blockMyJobHelper.openBlockMyJob();
        blockMyJobHelper.node_SelectSubnode_project("Проекты");

        // Step 6 - открываем форму редактирования документа и проверяем, что открыта именно форма редактирования.
        blockMyJobHelper.CheckAndOpenTheDocForEditing(docNumber, "Проект");
        formEditDocHelper.checkFormEdit("Акт");

        // Step 7 - Меняем категорию документа. Проверяем соответствие.
        categoryDocHelper.deletedCategoryAndSelectedNew("ДВП");

        // Step 8 - Сохранить изменения, проверяем категорию повторно.
        formEditDocHelper.saveChanges();
        docHelper.checkCategoryDoc("ДВП");

        // Step 9 - Удаляем документ, проверяем текстовое сообщение "Документ был удален.".
        actionPanelHelper.deleteDoc();
        bannerHelper.checkBannerDocWasDeleted();

        // Step 10 - Проверяем, что документ удален.
        blackBarHelper.clickOnKsed();
        blockMyJobHelper.openBlockMyJob();
        blockMyJobHelper.node_SelectSubnode_project("Проекты");
        blockMyJobHelper.checkDeletedDoc(docNumber, "Проект");

        Selenide.sleep(1000); // Для просмора итога
    }
}