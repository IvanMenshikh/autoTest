package Helper;

import Page.CreationDocPage;
import Page.FormEditDocPage;
import org.assertj.core.api.SoftAssertions;

public class FormEditDocHelper {

    FormEditDocPage formEditDocPage = new FormEditDocPage();
    CreationDocPage creationDocPage = new CreationDocPage();
    SoftAssertions softly = new SoftAssertions();

    public void checkFormEdit(String docType){
        softly.assertThat(creationDocPage.getFieldDocCategory(docType).innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(formEditDocPage.getNumber().innerText()).as("Номер").isEqualTo("Номер:");
        softly.assertAll();
    }
}
