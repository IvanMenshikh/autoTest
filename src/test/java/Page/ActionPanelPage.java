package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class ActionPanelPage {

    // Действие "Удалить".
    @Getter
    public final SelenideElement deleteDocAction = $x("//div[@class = 'bordered-panel']//*[@title = 'Удалить']");

    // Кнопка "ОК" в модальном окне действия "Удалить".
    @Getter
    public final SelenideElement deleteDocAction_btnOk = $x("//div[@id = 'prompt_c']//*[text() = 'OK']");
}
