package Helper;

import Object.Users;
import Page.CreationFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class ApprovalRouteHelper {

    CreationFormPage creationFormPage = new CreationFormPage();

    @Step("Операция по созданию маршрута согласования.")
    public void createApprovalRoute(String typeRoute) {
        creationFormPage.getRoute_BtnCreateRoute().click();
        creationFormPage.getRoute_SelectRouteType(typeRoute).click();
        creationFormPage.getRoute_BtnConfirmationCreateRoute().click();
    }

    @Step("Операция по созданию этапа согласования в маршруте согласования.")
    public void createApprovalStage(String stageType) {
        creationFormPage.getStage_BtnAddStage().click();
        creationFormPage.getStage_BtnConfirmationStage().shouldBe(visible);
        creationFormPage.getStage_BtnAddStageType().click();
        creationFormPage.getStage_SelectStageType(stageType).click();
        creationFormPage.getStage_BtnConfirmationStageType().click();
        creationFormPage.getStage_BtnConfirmationStage().click();
    }

    // ВНИМАНИЕ.
    // Метод в процессе реализации.
    @Step("Операция по добавлению пользователя в этап согласования, через иконку человечка.")
    public void addItemStage(){
        creationFormPage.getDoc_BtnAddItemStage().click();
        creationFormPage.getDoc_ModalWindow_SearchItemStage().setValue(Users.iniciator_ACard.getSurname()).pressEnter();
    }
}
