package Helper;

import Page.CreationDocPage;
import Page.FormEditDocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class FormEditDocHelper {

    FormEditDocPage formEditDocPage = new FormEditDocPage();
    CreationDocPage creationDocPage = new CreationDocPage();
    SoftAssertions softly = new SoftAssertions();

    @Step("Операция проверки формы редактирования документа")
    public void checkFormEdit(String docType){
        softly.assertThat(creationDocPage.getFieldDocCategory(docType).innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(formEditDocPage.getNumber().innerText()).as("Номер").isEqualTo("Номер:");
        softly.assertAll();
    }

    @Step("Сохранить изменения.")
    public void saveChanges(){
        formEditDocPage.getBtnSave().click();
    }
}
