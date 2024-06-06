package Helper;

import Page.CreationFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class CreationDocHelper {

    CreationFormPage creationFormPage = new CreationFormPage();

    @Step("Операция ожидания проприсовки страницы по локаторам в КС.")
    public void checkApprovalCard() {
        creationFormPage.getFieldDocForInformation().shouldBe(visible);
        creationFormPage.getDoc_CheckDocTitle("Карточка согласования").shouldBe(visible);
    }

    @Step("Заполняем поле заголовок.")
    public void writeTitle_ApprovalCard(String title){
        creationFormPage.getFieldTitleApprovalCard().setValue(title);
    }

    @Step("Операция 'Сохранить проект'")
    public void createProjectDoc(){
        creationFormPage.getBtnSaveProject().click();
    }
}
