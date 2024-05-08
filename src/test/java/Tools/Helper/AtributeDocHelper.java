package Tools.Helper;

import Page.CreationFormPage;
import Object.Users;

import static com.codeborne.selenide.Condition.visible;

public class AtributeDocHelper {

    // Вид документа, выбираем вид и элемент вида.
    public void docType_catalog(String typeApprovalCard, String elTypeApprovalCard){
        CreationFormPage.getTypeApprovalCard_SelectType(typeApprovalCard).click();
        CreationFormPage.getTypeApprovalCard_SelectCatalogElement(elTypeApprovalCard).click();
    }

    // Категория документа "Открытый", "ДВП", "СКХ".
    public void docCategory(String category){
        CreationFormPage.getDoc_CategoryDoc().click();
        CreationFormPage.getCategoryDoc_SelectCategory(category).click();
        CreationFormPage.getDoc_ButtonOkCategory().click();
    }

    // Создаем маршрут согласования "Индивидуальный маршрут", либо "Типовой", выбираем Вид этапа
    public void createApprovalRoute(String typeRoute, String typeApprovalCard){
        CreationFormPage.getRoute_ButtonCreateRoute().click();
        CreationFormPage.getRoute_SelectRouteType(typeRoute).click();
        CreationFormPage.getRoute_ButtonConfirmationCreateRoute().click();
        CreationFormPage.getStage_ButtonAddStage().click();
        CreationFormPage.getStage_ButtonAddStageType().click();
        CreationFormPage.getTypeApprovalCard_SelectType(typeApprovalCard).click();
        CreationFormPage.getStage_ButtonConfirmationStageType().click();
        CreationFormPage.getStage_FieldApprovingUser().setValue(Users.author_ApprovalCard.getSurname()).pressEnter();//Доработать
        CreationFormPage.getStage_AssertApprovingUser().shouldBe(visible);
        CreationFormPage.getStage_ButtonConfirmationStage().click();
    }

}
