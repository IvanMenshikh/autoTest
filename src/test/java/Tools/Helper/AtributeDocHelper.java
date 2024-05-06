package Tools.Helper;

import Page.CreationFormPage;

public class AtributeDocHelper {

    // Вид документа, выбираем вид и элемент вида.
    public void docType_catalog(String catalog, String el){
        CreationFormPage.getDocumentTypeCatalog(catalog).click();
        CreationFormPage.getDocumentTypeCatalogElement(el).click();
    }

    //Категория документа "Открытый", "ДВП", "СКХ".
    public void docCategory(String type){
        CreationFormPage.getDocCategory().click();
        CreationFormPage.getSelectCategory(type).click();
        CreationFormPage.getButtonOkCategory().click();
    }

    public void createApprovalRoute(String type, String catalog){
        CreationFormPage.getButtonCreateRoute().click();
        CreationFormPage.getRouteType(type).click();
        CreationFormPage.getButtonConfirmationCreateRoute().click();
        CreationFormPage.getButtonAddStage().click();
        CreationFormPage.getButtonAddStageType().click();
        CreationFormPage.getStageTypeCatalog(catalog).click();
        CreationFormPage.getButtonConfirmationStageType().click();
    }

}
