package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class CreationFormPage {

    // Вид документа.
    @Getter
    private SelenideElement documentType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Категория документа.
    @Getter
    private SelenideElement documentCategory = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    private SelenideElement buttonOkDocType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    private SelenideElement buttonOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Поле "Заголовок" в форме создания КС.
    @Getter
    private SelenideElement titleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Вид документа -> Каталог
    public SelenideElement getDocumentTypeCatalog(String category) {
        return $x("//span[text()='" + category + "']");
    }

    // Вид документа -> Каталог -> Выбрать элемент каталога.
    public SelenideElement getDocumentTypeCatalogElement(String el) {
        return $x("//span[text()='" + el + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Категория документа -> выбрать категорию.
    public SelenideElement getSelectCategory(String type) {
        return $x("//span[text()='" + type + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }
}

//    // Вид документа.
//    public static SelenideElement getDocumentType(){
//        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");
//    }
//
//    // Вид документа -> Каталог
//    public static SelenideElement getDocumentTypeCatalog(String category){
//        return $x("//span[text()='"+ category +"']");
//    }
//
//    // Вид документа -> Каталог -> Выбрать элемент каталога.
//    public static SelenideElement getDocumentTypeCatalogElement(String el){
//        return $x("//span[text()='"+ el +"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
//    }
//
//    // Кнопка "ОК" в модалке "Вид документа".
//    public static SelenideElement getButtonOk_DocType(){
//        return $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");
//    }
//
//    // Категория документа.
//    public static SelenideElement getDocumentCategory(){
//        return $x("//button[contains(@id, 'category') and text() = '...']");
//    }
//
//    // Категория документа -> выбрать категорию.
//    public static SelenideElement getSelectCategory(String type){
//        return $x("//span[text()='"+ type +"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
//    }
//
//    // Кнопка "ОК" в модалке "Категория документа".
//    public static SelenideElement getButtonOk_Category(){
//        return $x("//button[contains(@id, 'category') and text() = 'OK']");
//    }
//
//    // Заголовок.
//    public static SelenideElement getTitleKs(){
//        return $x("//input[@name = 'prop_lecm-document_title']");
//    }

