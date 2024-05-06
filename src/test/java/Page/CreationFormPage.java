package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class CreationFormPage {

    // Вид документа.
    @Getter
    public static SelenideElement documentType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Категория документа.
    @Getter
    public static SelenideElement documentCategory = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    public static SelenideElement buttonOkDocType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    public static SelenideElement buttonOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Поле "Заголовок" в форме создания КС.
    @Getter
    public static SelenideElement titleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Вид документа -> Каталог
    public static SelenideElement getDocumentTypeCatalog(String category) {
        return $x("//span[text()='" + category + "']");
    }

    // Вид документа -> Каталог -> Выбрать элемент каталога.
    public static SelenideElement getDocumentTypeCatalogElement(String el) {
        return $x("//span[text()='" + el + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Категория документа -> выбрать категорию.
    public static SelenideElement getSelectCategory(String type) {
        return $x("//span[text()='" + type + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }
}