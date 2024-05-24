package Helper;

import Object.Users;
import Page.CreationFormPage;

import static com.codeborne.selenide.Condition.visible;

public class ApprovalRouteHelper extends CreationFormPage{

    // Создаем маршрут согласования.
    public void createApprovalRoute(String typeRoute) {
        getRoute_BtnCreateRoute().click();
        getRoute_SelectRouteType(typeRoute).click();
        getRoute_BtnConfirmationCreateRoute().click();
    }

    // Создаем этап согласования.
    public void createApprovalStage(String stageType) {
        getStage_BtnAddStage().click();
        getStage_BtnConfirmationStage().shouldBe(visible);
        getStage_BtnAddStageType().click();
        getStage_SelectStageType(stageType).click();
        getStage_BtnConfirmationStageType().click();
        getStage_BtnConfirmationStage().click();
    }

    // ВНИМАНИЕ.
    // Не сделано до конца!!!
    // Добавляем согласующего по иконке человечка.
    public void addItemStage(){
        getDoc_BtnAddItemStage().click();
        getModalWindow_SearchItemStage().setValue(Users.iniciator_ACard.getSurname()).pressEnter();
    }
}
