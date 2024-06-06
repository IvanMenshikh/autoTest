package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class ApprovalRoutePage {

    // Кнопка "Создать маршрут"
    @Getter
    public final SelenideElement route_BtnCreateRoute = $x("//button[text() = 'Создать маршрут']");

    // Кнопка "Ок" для подтверждения модалки создания маршрута согласования.
    @Getter
    public final SelenideElement route_BtnConfirmationCreateRoute = $x("//button[text() = 'ОК']");

    // Кнопка "Добавить этап"
    @Getter
    public final SelenideElement stage_BtnAddStage = $x("//button[text() = 'Добавить этап']");

    // Кнопка [...] - Вид этапа.
    @Getter
    public final SelenideElement stage_BtnAddStageType = $x("//button[contains(@id, 'stage-type-cntrl-tree-picker-button')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> выбрать элемент справочника -> ОК.
    @Getter
    public final SelenideElement stage_BtnConfirmationStageType = $x("//button[contains(@id, 'stage-type-cntrl-ok')]");

    // Поле "Согласующие".
    @Getter
    public final SelenideElement stage_FieldApprovingUser = $x("//input[contains(@id, 'approvers-autocomplete')]");

    // Доп. модалка, которая появляется, когда добавляешь согласующего в этапе.
    @Getter
    public final SelenideElement stage_AssertApprovingUser = $x("//div[contains(@id, 'approvers-displayed')]");

    // Кнопка "Ок" для подтверждения Вид этапа -> Ок (СОЗДАТЬ).
    @Getter
    public final SelenideElement stage_BtnConfirmationStage = $x("//button[contains(@id, 'undefined-form-submit-button')]");

    // Кнопка "Добавить согласующего" - "Человечек".
    @Getter
    public final SelenideElement stage_BtnAddItemStage = $x("//td[contains(@class, 'col-actions yui-dt-last')]//a[@title = 'Добавить сотрудника']");

    // Модалка для выбора пользователя в этап согласования.
    @Getter
    public final SelenideElement stage_ModalWindow_SearchItemStage = $x("//input[contains(@id, 'picker-employee-search-text')]");

    // Вид этапа -> выбрать элемент справочника.
    public SelenideElement getStage_SelectStageType(String stageType){
        return $x("//span[text()='" + stageType + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    // Выбрать тип маршрута согласования "Индивидуальный маршрут", "Типовой".
    public SelenideElement getRoute_SelectRouteType(String typeRoute){
        return $x("//a[text()='" + typeRoute + "']");
    }

}
