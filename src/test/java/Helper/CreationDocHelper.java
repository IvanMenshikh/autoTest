package Helper;

import Page.CreationDocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.visible;

public class CreationDocHelper {

    CreationDocPage creationDocPage = new CreationDocPage();
    SoftAssertions softly = new SoftAssertions();

    @Step("Операция ожидания проприсовки страницы по локаторам в КС.")
    public void checkApprovalCard() {
        creationDocPage.getFieldDocForInformation().shouldBe(visible);
        creationDocPage.getDoc_CheckDocTitle("Карточка согласования").shouldBe(visible);
    }

    @Step("Заполняем поле заголовок.")
    public void writeTitle_ApprovalCard(String title){
        creationDocPage.getFieldTitleApprovalCard().setValue(title);
    }

    @Step("Операция 'Сохранить проект.'")
    public void createProjectDoc(){
        creationDocPage.getBtnSaveProject().click();
    }

    @Step("Операция проверки полей на форме создания документа.")
    public void CheckCompletedFields(String docType, String docCategory){
        softly.assertThat(creationDocPage.getFieldDocType(docType).innerText()).as("Поле 'Вид документа'").isEqualTo("Акт");
        softly.assertThat(creationDocPage.getFieldTitleApprovalCard().innerText()).as("Поле 'Заголовок'").isEqualTo("Тестовый документ. Меньших И.А.");
        softly.assertThat(creationDocPage.getFieldDocCategory(docCategory).innerText()).as("Поле 'Категория документа'").isEqualTo("Открытый");
    }
}
