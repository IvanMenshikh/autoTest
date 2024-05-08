package Tools.Helper;

import Page.CreationFormPage;
import Object.Users;

import static com.codeborne.selenide.Condition.visible;

public class AtributeDocHelper {

    // Вид документа, выбираем вид и элемент вида.
    public void docType_catalog(String catalog, String el){
        CreationFormPage.getDocumentTypeCatalog(catalog).click();
        CreationFormPage.getDocumentTypeCatalogElement(el).click();
    }

    // Категория документа "Открытый", "ДВП", "СКХ".
    public void docCategory(String type){
        CreationFormPage.getDoc_CategoryDoc().click();
        CreationFormPage.getSelectCategory(type).click();
        CreationFormPage.getDoc_ButtonOkCategory().click();
    }

    // Создаем маршрут согласования "Индивидуальный маршрут", либо "Типовой", выбираем Вид этапа
    public void createApprovalRoute(String type, String catalog){
        CreationFormPage.getRoute_ButtonCreateRoute().click();
        CreationFormPage.getRouteType(type).click();
        CreationFormPage.getRoute_ButtonConfirmationCreateRoute().click();
        CreationFormPage.getStage_ButtonAddStage().click();
        CreationFormPage.getStage_ButtonAddStageType().click();
        CreationFormPage.getStageTypeCatalog(catalog).click();
        CreationFormPage.getStage_ButtonConfirmationStageType().click();
        CreationFormPage.getStage_FieldApprovingUser().setValue(Users.author_ApprovalCard.getSurename()).pressEnter();//Доработать
        CreationFormPage.getStage_AssertApprovingUser().shouldBe(visible);
        CreationFormPage.getStage_ButtonConfirmationStage().click();
    }

}
