package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class BannerPage {

    // Баннер: Документ был удален.
    @Getter
    public final SelenideElement docWasDeleted = $x("//div[contains(text(), 'Документ был удален.')]");
}
