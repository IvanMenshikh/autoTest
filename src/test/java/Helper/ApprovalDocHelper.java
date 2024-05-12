package Helper;

import Page.CreationFormPage;
import Object.Users;

import static com.codeborne.selenide.Condition.visible;

public class ApprovalDocHelper extends CreationFormPage{

    // Создаем маршрут согласования "Индивидуальный маршрут", либо "Типовой", выбираем Вид этапа
    public void createApprovalRoute(String typeRoute, String stageType){

        // Отжимаем кнопку "Создать маршрут".
        getRoute_ButtonCreateRoute().click();

        // Выбираем тип маршрута.
        getRoute_SelectRouteType(typeRoute).click();

        // В доп. модальном окне отжмаем "Ок".
        getRoute_ButtonConfirmationCreateRoute().click();

        // Отжимаем кнопку "Добавить этап". Проверяем, что модалка открылась по кнопке "Ок".
        getStage_ButtonAddStage().click();
        getStage_ButtonConfirmationStage().shouldBe(visible);

        // Открываем список виды этапов и выбираем вид этапа, подтверждаем выбор.
        getStage_ButtonAddStageType().click();
        getStage_SelectStageType(stageType).click();
        getStage_ButtonConfirmationStageType().click();

        // Выбираем согласующего, проверяем, что согласующий добавлен, подтверждаем создание вида этапа.
        getStage_FieldApprovingUser().setValue(Users.author_ApprovalCard.getSurname()).pressEnter();
        getStage_AssertApprovingUser().shouldBe(visible);
        getStage_ButtonConfirmationStage().click();
    }
}
