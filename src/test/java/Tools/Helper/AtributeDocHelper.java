package Tools.Helper;

import Object.Users;
import Page.CreationFormPage;

import static com.codeborne.selenide.Condition.visible;

public class AtributeDocHelper {

    CreationFormPage creationFormPage = new CreationFormPage();

    // Вид документа, выбираем вид и элемент вида. (Вид "Прочие", элемент вида "Акт")
    public void docType_catalog(String typeApprovalCard, String elTypeApprovalCard){
        creationFormPage.getTypeApprovalCard_SelectType(typeApprovalCard).click();
        creationFormPage.getTypeApprovalCard_SelectCatalogElement(elTypeApprovalCard).click();
    }

    // Категория документа "Открытый", "ДВП", "СКХ".
    public void docCategory(String category){
        creationFormPage.getDoc_CategoryDoc().click();
        creationFormPage.getCategoryDoc_SelectCategory(category).click();
        creationFormPage.getDoc_ButtonOkCategory().click();
    }

    // Создаем маршрут согласования "Индивидуальный маршрут", либо "Типовой", выбираем Вид этапа
    public void createApprovalRoute(String typeRoute, String stageType){
        creationFormPage.getRoute_ButtonCreateRoute().click();
        creationFormPage.getRoute_SelectRouteType(typeRoute).click();
        creationFormPage.getRoute_ButtonConfirmationCreateRoute().click();
        creationFormPage.getStage_ButtonAddStage().click();
        creationFormPage.getStage_ButtonAddStageType().click();
        creationFormPage.getStage_SelectStageType(stageType).click();
        creationFormPage.getStage_ButtonConfirmationStageType().click();
        creationFormPage.getStage_FieldApprovingUser().setValue(Users.author_ApprovalCard.getSurname()).pressEnter();
        creationFormPage.getStage_AssertApprovingUser().shouldBe(visible);
        creationFormPage.getStage_ButtonConfirmationStage().click();
    }

}
