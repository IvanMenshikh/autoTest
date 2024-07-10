package Helper;

import Page.DocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class docHelper {

    DocPage docPage = new DocPage();
    SoftAssertions softly = new SoftAssertions();

    public String getDocRegNumber() {
        return docPage.docNum.getText();
    }

    @Step("Проверяем, что РК КС создана, атрибуты отобразились.")
    public void checkLoadDoc(String docCategory, String docType, String docStatus) {
        softly.assertThat(docPage.getFieldCategoryDoc(docCategory).innerText()).as("Категория документа").isEqualTo("Открытый");
        softly.assertThat(docPage.getFieldDocType(docType).innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(docPage.getFieldStateMachineStatus(docStatus).innerText()).as("Статус документа").isEqualTo("Проект");
        softly.assertAll();
    }

    @Step("Проверяем, что в РК КС категория документа совпадается с ожиданием (ДВП).")
    public void checkCategoryDoc(String docCategory){
        softly.assertThat(docPage.getFieldCategoryDoc(docCategory).innerText()).as("Категория документа").isEqualTo("ДВП");

    }

}

