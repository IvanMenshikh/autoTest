package Helper;

import Page.CreationFormPage;
import Page.DefoultDocPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class ConstructorApprovalCardHelper {

    CreationFormPage creationFormPage = new CreationFormPage();
    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();
    ApprovalRouteHelper approvalRouteHelper = new ApprovalRouteHelper();
    DefoultDocPage defoultDocPage = new DefoultDocPage();


    @Step("Операция ожиданий загрузки страницы КС.")
    public void checkApprovalCard() {
        creationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
        creationFormPage.getDoc_CheckDocTitle("Карточка согласования").shouldBe(visible);
    }

    @Step("Выбираем вид документа в КС. Прочие -> Акт.")
    public void selectDocType() {
        creationFormPage.getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        creationFormPage.getDoc_BtnOkDocType().click();
    }

    @Step("Заполняем поле заголовок.")
    public void writeTitle_ApprovalCard(String title){
        creationFormPage.getDoc_FieldTitleApprovalCard().setValue(title);
    }

    @Step("Создаем маршрут согласования. Индивидуальный маршрут -> Согласование КС.")
    public void createApprovalRoute() {
        approvalRouteHelper.createApprovalRoute("Индивидуальный маршрут");
        approvalRouteHelper.createApprovalStage("Согласование КС");
    }

    @Step("Проверяем, что РК КС создана, атрибуты отобразились.")
    public void checkAtributeNewDoc(){
        defoultDocPage.getFieldCategoryDoc("Открытый").shouldBe(visible);
        defoultDocPage.getFieldDocType("Акт").shouldBe(visible);
        defoultDocPage.getFieldStateMachineStatus("Проект").shouldBe(visible);
    }
}
