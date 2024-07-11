package Helper;

import Page.BannerPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

public class BannerHelper {

    BannerPage bannerPage = new BannerPage();
    SoftAssertions softly = new SoftAssertions();

    @Step("Проверяем баннер после удаления документа инициатором.")
    public void checkBannerDocWasDeleted(){
        softly.assertThat(bannerPage.getDocWasDeleted().innerText()).as("Баннер: Документ был удален").isEqualTo("\n" +
                "            Документ был удален.\n" +
                "        "); // Очень странная история, у элемента //div[contains(text(), 'Документ был удален.')] много пробелов в тексте.
        softly.assertAll();
    }
}
