package Helper;

import Object.Users;
import Page.ApprovalRoutePage;
import Page.CreationFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class ApprovalRouteHelper {

    CreationFormPage creationFormPage = new CreationFormPage();
    ApprovalRoutePage approvalRoutePage = new ApprovalRoutePage();

    @Step("Операция по созданию маршрута согласования.")
    public void createApprovalRoute(String typeRoute) {
        approvalRoutePage.getRoute_BtnCreateRoute().click();
        approvalRoutePage.getRoute_SelectRouteType(typeRoute).click();
        approvalRoutePage.getRoute_BtnConfirmationCreateRoute().click();
    }

    @Step("Операция по созданию этапа согласования в маршруте согласования.")
    public void createApprovalStage(String stageType) {
        approvalRoutePage.getStage_BtnAddStage().click();
        approvalRoutePage.getStage_BtnConfirmationStage().shouldBe(visible);
        approvalRoutePage.getStage_BtnAddStageType().click();
        approvalRoutePage.getStage_SelectStageType(stageType).click();
        approvalRoutePage.getStage_BtnConfirmationStageType().click();
        approvalRoutePage.getStage_BtnConfirmationStage().click();
    }

    // ВНИМАНИЕ.
    // Метод в процессе реализации.
    @Step("Операция по добавлению пользователя в этап согласования, через иконку человечка.")
    public void addItemStage(){
        approvalRoutePage.getStage_BtnAddItemStage().click();
        approvalRoutePage.getDoc_ModalWindow_SearchItemStage().setValue(Users.iniciator_ACard.getSurname()).pressEnter();
    }
}
