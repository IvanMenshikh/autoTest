package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreationFormPage_KS {
    public static SelenideElement documentType;// Вид документа.
    public static SelenideElement documentTypeCatalog;// Вид документа -> Выбрать каталог.
    public static SelenideElement DocumentTypeCatalogElement;// Вид документа -> Каталог -> Выбрать элемент каталога.
    public static SelenideElement buttonOk;// Кнопка "ОК".
    public static SelenideElement titleKs;// Заголовок.

    public static SelenideElement getDocumentType(){
        return documentType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");
    }

    public static SelenideElement getTitleKs(){
        return titleKs = $x("//input[@name = 'prop_lecm-document_title']");
    }

    public static SelenideElement getDocumentTypeCatalog(String catalog){
        return documentTypeCatalog = $x("//span[text()='\"+ catalog +\"']");
    }

    public static SelenideElement getDocumentTypeCatalogElement(String el){
        return DocumentTypeCatalogElement = $x("//span[text()='\"+ el +\"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    public static SelenideElement getButtonOk(){
        return buttonOk = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");
    }
}
