package Helper;

import Page.DefoultDocPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class DefoultDocHelper {

    DefoultDocPage defoultDocPage = new DefoultDocPage();

    @Step("Проверяем, что РК КС создана, атрибуты отобразились.")
    public void checkAtributeNewDoc(){
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(defoultDocPage.getFieldCategoryDoc("Открытый"))
                .as("Ошибка: Обрати внимание на элемент 'Категория документа'.");
        softAssertions.assertThat(defoultDocPage.getFieldDocType("Акт"))
                .as("Ошибка: Обрати внимание на элемент 'Вид документа'");
        softAssertions.assertThat(defoultDocPage.getFieldStateMachineStatus("Проект"))
                .as("Ошибка: Обрати внимание на элемент 'Статус документа'");

        softAssertions.assertAll();
    }
}
