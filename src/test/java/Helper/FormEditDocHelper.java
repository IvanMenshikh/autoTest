package Helper;

import Page.DocPage;
import Page.FormEditDocPage;
import org.assertj.core.api.SoftAssertions;

public class FormEditDocHelper {

    FormEditDocPage formEditDocPage = new FormEditDocPage();
    DocPage docPage = new DocPage();
    SoftAssertions softly = new SoftAssertions();

    public void checkFormEdit(String docType){
        softly.assertThat(formEditDocPage.getCategory(docType).innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(formEditDocPage.getNumber().innerText()).as("Номер").isEqualTo("Номер:");
        softly.assertAll();
    }
}
