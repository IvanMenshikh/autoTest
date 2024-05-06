package Tools.Helper;

import Page.CreationFormPage;

public class AtributeDocHelper {

    // Вид документа, выбираем вид и элемент вида.
    public static void docType_catalog(String catalog, String el){
        CreationFormPage.getDocumentTypeCatalog(catalog).click();
        CreationFormPage.getDocumentTypeCatalogElement(el).click();
    }

    //Категория документа "Открытый", "ДВП", "СКХ".
    public static void docCategory(String type){
        CreationFormPage.getDocumentCategory().click();
        CreationFormPage.getSelectCategory(type).click();
        CreationFormPage.getButtonOkCategory().click();
    }

}
