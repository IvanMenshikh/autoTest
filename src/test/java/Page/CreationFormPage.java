package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class CreationFormPage {

    // Вид документа.
    @Getter
    private final SelenideElement doc_TypeApprovalCard = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Категория документа.
    @Getter
    private final SelenideElement doc_CategoryDoc = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    private final SelenideElement doc_ButtonOkDocType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    private final SelenideElement doc_ButtonOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Поле "Заголовок" в форме создания КС.
    @Getter
    private final SelenideElement doc_FieldTitleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Поле документы "Для информации". Использую для ожидания прорисовки страницы.
    @Getter
    private final SelenideElement doc_FieldDocForInformation = $x("//legend[text() = 'Документы для информации']");

    // Поле документы "Для рассмотрения". Использую для загрузки вложения.
    @Getter
    private final SelenideElement doc_FieldDocForConsiderations = $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]");

    // Кнопка "Выберите файлы". Появляется при добавлении вложений. //button[text() = 'Выберите файлы']
    @Getter
    private final SelenideElement attachmen_ButtonSelectFiles = $x("//input[@name = 'files[]']");

    // Кнопка "Печать". Появляется после загрузки вложения.
    @Getter
    private final SelenideElement attachmen_ButtonPrint = $x("//button[@title = 'Печать']");

    // Контент вложения. Появится после загрузки вложения (текст в предпросмотре).
    @Getter
    private final SelenideElement attachmen_content = $x("//div[text() = '000000000000000000000000000000000']");

    // Кнопка "Создать маршрут"
    @Getter
    private final SelenideElement route_ButtonCreateRoute = $x("//button[text() = 'Создать маршрут']");

    // Кнопка "Ок" для подтверждения модалки создания маршрута согласования.
    @Getter
    private final SelenideElement route_ButtonConfirmationCreateRoute = $x("//button[text() = 'ОК']");

    // Кнопка "Добавить этап"
    @Getter
    private final SelenideElement stage_ButtonAddStage = $x("//button[text() = 'Добавить этап']");

    // Кнопка [...] - Вид этапа.
    @Getter
    private final SelenideElement stage_ButtonAddStageType = $x("//button[contains(@id, 'stage-type-cntrl-tree-picker-button')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> выбрать элемент справочника -> ОК.
    @Getter
    private final SelenideElement stage_ButtonConfirmationStageType = $x("//button[contains(@id, 'stage-type-cntrl-ok')]");

    // Поле "Согласующие".
    @Getter
    private final SelenideElement stage_FieldApprovingUser = $x("//input[contains(@id, 'approvers-autocomplete')]");

    // Доп. модалка, которая появляется, когда добавляешь согласующего в этапе.
    @Getter
    private final SelenideElement stage_AssertApprovingUser = $x("//div[contains(@id, 'approvers-displayed')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> Ок (СОЗДАТЬ).
    @Getter
    private final SelenideElement stage_ButtonConfirmationStage = $x("//button[contains(@id, 'undefined-form-submit-button')]");

    // Кнопка "Сохранить проект".
    @Getter
    private final SelenideElement doc_ButtonSaveProject = $x("//button[text() = 'Сохранить проект']");


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
    public static SelenideElement getDoc_CheckDocTitle(String docType){
        return $x("//span[text() = 'Создать документ \"" + docType + "\"']");
    }
}