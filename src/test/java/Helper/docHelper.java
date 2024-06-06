package Helper;

import Page.DocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class docHelper {

    DocPage docPage = new DocPage();

    @Step("Проверяем, что РК КС создана, атрибуты отобразились.")
    public void checkLoadDoc() {

        SoftAssertions softly = new SoftAssertions();
        // В работе
        softly.assertThat(docPage.getFieldCategoryDoc("Открытый").innerText()).as("Категория документа").isEqualTo("ДВП");
        softly.assertThat(docPage.getFieldDocType("Акт").innerText()).as("Вид документа").isEqualTo("Акт");
        softly.assertThat(docPage.getFieldStateMachineStatus("Проект").innerText()).as("Статус документа").isEqualTo("Проект");

        softly.assertAll();
    }
}

