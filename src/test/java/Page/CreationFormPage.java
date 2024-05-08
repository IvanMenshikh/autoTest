package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class CreationFormPage {

    // Вид документа.
    @Getter
    public static SelenideElement doc_TypeDoc = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Категория документа.
    @Getter
    public static SelenideElement doc_CategoryDoc = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    public static SelenideElement doc_ButtonOkDocType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    public static SelenideElement doc_ButtonOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Поле "Заголовок" в форме создания КС.
    @Getter
    public static SelenideElement doc_FieldTitleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Поле документы "Для информации". Использую для ожидания прорисовки страницы.
    @Getter
    public static SelenideElement doc_FieldDocForInformation = $x("//legend[text() = 'Документы для информации']");

    // Поле документы "Для рассмотрения". Использую для загрузки вложения.
    @Getter
    public static SelenideElement doc_FieldDocForConsiderations = $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]");

    // Кнопка "Выберите файлы". Появляется при добавлении вложений. //button[text() = 'Выберите файлы']
    @Getter
    public static SelenideElement attachmen_ButtonSelectFiles = $x("//input[@name = 'files[]']");

    // Кнопка "Печать". Появляется после загрузки вложения.
    @Getter
    public static SelenideElement attachmen_ButtonPrint = $x("//button[@title = 'Печать']");

    // Кнопка "Создать маршрут"
    @Getter
    public static SelenideElement route_ButtonCreateRoute = $x("//button[text() = 'Создать маршрут']");

    // Кнопка "Ок" для подтверждения модалки создания маршрута согласования.
    @Getter
    public static SelenideElement route_ButtonConfirmationCreateRoute = $x("//button[text() = 'ОК']");

    // Кнопка "Добавить этап"
    @Getter
    public static SelenideElement stage_ButtonAddStage = $x("//button[text() = 'Добавить этап']");

    // Кнопка [...] - Вид этапа.
    @Getter
    public static SelenideElement stage_ButtonAddStageType = $x("//button[contains(@id, 'stage-type-cntrl-tree-picker-button')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> выбрать элемент справочника -> ОК.
    @Getter
    public static SelenideElement stage_ButtonConfirmationStageType = $x("//button[contains(@id, 'stage-type-cntrl-ok')]");

    // Поле "Согласующие".
    @Getter
    public static SelenideElement stage_FieldApprovingUser = $x("//input[contains(@id, 'approvers-autocomplete')]");

    // Доп. модалка, которая появляется, когда добавляешь согласующего в этапе.
    @Getter
    public static SelenideElement stage_AssertApprovingUser = $x("//div[contains(@id, 'approvers-association-control')]//child::a[contains(text(), 'Смокин118')] ");

    // Кнопка "Ок" для подтверждения Вид этапа -> Ок (СОЗДАТЬ).
    @Getter
    public static SelenideElement stage_ButtonConfirmationStage = $x("//button[contains(@id, 'undefined-form-submit-button')]");


    // Вид этапа -> выбрать элемент справочника.
    public static SelenideElement getStageTypeCatalog(String catalog){
        return $x("//span[text()='" + catalog + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Тип маршрута согласования "Индивидуальный маршрут", "Типовой".
    public static SelenideElement getRouteType(String type){
        return $x("//a[text()='" + type + "']");
    }

    // Вид документа -> Каталог
    public static SelenideElement getDocumentTypeCatalog(String category) {
        return $x("//span[text()='" + category + "']");
    }

    // Вид документа -> Каталог -> Выбрать элемент справочника.
    public static SelenideElement getDocumentTypeCatalogElement(String el) {
        return $x("//span[text()='" + el + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Категория документа -> выбрать категорию.
    public static SelenideElement getSelectCategory(String type) {
        return $x("//span[text()='" + type + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }
}