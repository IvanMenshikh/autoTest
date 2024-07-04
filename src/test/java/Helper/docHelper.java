package Helper;

import Page.DocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class docHelper {

    DocPage docPage = new DocPage();

    public String getDocRegNumber() {
        return docPage.docNum.getText();
    }

    @Step("Проверяем, что РК КС создана, атрибуты отобразились.")
    public void checkLoadDoc() {

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(docPage.getFieldCategoryDoc("Открытый").innerText()).as("Категория документа").isEqualTo("Открытый");
        softly.assertThat(docPage.getFieldDocType("Акт").innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(docPage.getFieldStateMachineStatus("Проект").innerText()).as("Статус документа").isEqualTo("Проект");
        softly.assertAll();
    }
}

