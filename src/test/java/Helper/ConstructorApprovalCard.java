package Helper;

import Page.CreationFormPage;
import Tools.Asserts;

import static com.codeborne.selenide.Condition.visible;

public class ConstructorApprovalCard extends CreationFormPage{

    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();
    ApprovalRouteHelper approvalRouteHelper = new ApprovalRouteHelper();
    Asserts asserts = new Asserts();

    // Проверяем форму создания - "Карточка согласования". (Ожидаем появления поля "Документы для информации", проверяем заголовок.)
    public void checkApprovalCard() {
        getDoc_FieldDocForInformation().shouldBe(visible);
        asserts.checkDocTitle("Карточка согласования", "Карточка согласования");
    }

    // Выбираем вид документа "Карточка согласования". (Прочиее --> Акт.)
    public void selectDocType() {
        getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        getDoc_BtnOkDocType().click();
    }

    // Записываем значение в поле "Заголовок" - Карточка согласования.
    public void writeTitle_ApprovalCard(String title){
        getDoc_FieldTitleApprovalCard().setValue(title);
    }

    // Создаем маршрут согласования.
    public void createApprovalRoute() {
        approvalRouteHelper.createApprovalRoute("Индивидуальный маршрут");
        approvalRouteHelper.createApprovalStage("Согласование КС");
    }

    // Отжимаем кнопку "Сохранить проект".
    public void createProjectDoc(){
        getDoc_BtnSaveProject().click();
    }
}
