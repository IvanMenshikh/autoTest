package Helper;

import Page.CreationFormPage;
import Object.Users;

import static com.codeborne.selenide.Condition.visible;

public class ApprovalDocHelper extends CreationFormPage{

    // Создаем маршрут согласования "Индивидуальный маршрут", либо "Типовой", выбираем Вид этапа
    public void createApprovalRoute(String typeRoute, String stageType){
        getRoute_ButtonCreateRoute().click();
        getRoute_SelectRouteType(typeRoute).click();
        getRoute_ButtonConfirmationCreateRoute().click();
        getStage_ButtonAddStage().click();
        getStage_ButtonAddStageType().click();
        getStage_ButtonConfirmationStage().shouldBe(visible);
        getStage_SelectStageType(stageType).click();
        getStage_ButtonConfirmationStageType().click();
        getStage_FieldApprovingUser().setValue(Users.author_ApprovalCard.getSurname()).pressEnter();
        getStage_AssertApprovingUser().shouldBe(visible);
        getStage_ButtonConfirmationStage().click();
    }
}
