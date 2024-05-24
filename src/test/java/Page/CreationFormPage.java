package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class CreationFormPage {

    // Вид документа.
    @Getter
    public SelenideElement doc_TypeApprovalCard = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Категория документа.
    @Getter
    public SelenideElement doc_CategoryDoc = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    public SelenideElement doc_BtnOkDocType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    public SelenideElement doc_BtnOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Поле "Заголовок" в форме создания КС.
    @Getter
    public SelenideElement doc_FieldTitleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Поле документы "Для информации". Использую для ожидания прорисовки страницы.
    @Getter
    public SelenideElement doc_FieldDocForInformation = $x("//legend[text() = 'Документы для информации']");

    // Поле документы "Для рассмотрения". Использую для загрузки вложения.
    @Getter
    public SelenideElement doc_FieldDocForConsiderations = $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]");

    // Кнопка "Выберите файлы". Появляется при добавлении вложений. //button[text() = 'Выберите файлы']
    @Getter
    public SelenideElement attachmen_BtnSelectFiles = $x("//input[@name = 'files[]']");

    // Кнопка "Печать". Появляется после загрузки вложения.
    @Getter
    public SelenideElement attachmen_BtnPrint = $x("//button[@title = 'Печать']");

    // Контент вложения. Появится после загрузки вложения (текст в предпросмотре).
    @Getter
    public SelenideElement attachmen_content = $x("//div[text() = '000000000000000000000000000000000']");

    // Кнопка "Создать маршрут"
    @Getter
    public SelenideElement route_BtnCreateRoute = $x("//button[text() = 'Создать маршрут']");

    // Кнопка "Ок" для подтверждения модалки создания маршрута согласования.
    @Getter
    public SelenideElement route_BtnConfirmationCreateRoute = $x("//button[text() = 'ОК']");

    // Кнопка "Добавить этап"
    @Getter
    public SelenideElement stage_BtnAddStage = $x("//button[text() = 'Добавить этап']");

    // Кнопка [...] - Вид этапа.
    @Getter
    public SelenideElement stage_BtnAddStageType = $x("//button[contains(@id, 'stage-type-cntrl-tree-picker-button')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> выбрать элемент справочника -> ОК.
    @Getter
    public SelenideElement stage_BtnConfirmationStageType = $x("//button[contains(@id, 'stage-type-cntrl-ok')]");

    // Поле "Согласующие".
    @Getter
    public SelenideElement stage_FieldApprovingUser = $x("//input[contains(@id, 'approvers-autocomplete')]");

    // Доп. модалка, которая появляется, когда добавляешь согласующего в этапе.
    @Getter
    public SelenideElement stage_AssertApprovingUser = $x("//div[contains(@id, 'approvers-displayed')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> Ок (СОЗДАТЬ).
    @Getter
    public SelenideElement stage_BtnConfirmationStage = $x("//button[contains(@id, 'undefined-form-submit-button')]");

    // Кнопка "Сохранить проект".
    @Getter
    public SelenideElement doc_BtnSaveProject = $x("//button[text() = 'Сохранить проект']");

    // Кнопка "Добавить согласующего" - "Человечек".
    @Getter
    public SelenideElement doc_BtnAddItemStage = $x("//td[contains(@class, 'col-actions yui-dt-last')]//a[@title = 'Добавить сотрудника']");

    // Модалка для выбора пользователя в этап согласования.
    @Getter
    public SelenideElement modalWindow_SearchItemStage = $x("//input[contains(@id, 'picker-employee-search-text')]");

    // Вид этапа -> выбрать элемент справочника.
    public SelenideElement getStage_SelectStageType(String stageType){
        return $x("//span[text()='" + stageType + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Выбрать тип маршрута согласования "Индивидуальный маршрут", "Типовой".
    public SelenideElement getRoute_SelectRouteType(String typeRoute){
        return $x("//a[text()='" + typeRoute + "']");
    }

    // Вид документа -> Каталог, выбрать вид из "Прочие", "ЛНД", и тд...
    public SelenideElement getTypeApprovalCard_SelectType(String typeApprovalCard) {
        return $x("//span[text()='" + typeApprovalCard + "']");
    }

    // Вид документа -> Каталог -> Выбрать элемент справочника.
    public SelenideElement getTypeApprovalCard_SelectCatalogElement(String elTypeApprovalCard) {
        return $x("//span[text()='" + elTypeApprovalCard + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Категория документа -> выбрать категорию.
    public SelenideElement getCategoryDoc_SelectCategory(String category) {
        return $x("//span[text()='" + category + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Титульник "Создать документ " + Тип документа + ". Проверка.
    public SelenideElement getDoc_CheckDocTitle(String docType){
        return $x("//span[text() = 'Создать документ \"" + docType + "\"']");
    }
}