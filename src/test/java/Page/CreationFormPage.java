package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreationFormPage {

    // Вид документа.
    public static SelenideElement getDocumentType(){
        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");
    }

    // Вид документа -> Выбрать каталог.
    public static SelenideElement getTitleKs(){
        return $x("//input[@name = 'prop_lecm-document_title']");
    }

    // Вид документа -> Каталог -> Выбрать элемент каталога.
    public static SelenideElement getDocumentTypeCatalog(String category){
        return $x("//span[text()='"+ category +"']");
    }

    // Кнопка "ОК".
    public static SelenideElement getDocumentTypeCatalogElement(String el){
        return $x("//span[text()='"+ el +"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Заголовок.
    public static SelenideElement getButtonOk_DocType(){
        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");
    }

    // Категория документа.
    public static SelenideElement getDocumentCategory(){
        return $x("//button[contains(@id, 'category') and text() = '...']");
    }

    // Категория документа -> выбрать категорию.
    public static SelenideElement getSelectCategory(String type){
        return $x("//span[text()='"+ type +"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Кнопка "ОК".
    public static SelenideElement getButtonOk_Category(){
        return $x("//button[contains(@id, 'category') and text() = 'OK']");
    }


}
