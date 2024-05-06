package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class MainPage {

    // Кнопка "Создать".
    @Getter
    public static SelenideElement buttonCreate = $x("//button[text() = 'Создать']");

    // Кнопка вида документа "Карточка согласования".
    @Getter
    public static SelenideElement buttonDocTypeApprovalCard = $x("//a[text() = 'Карточка согласования']");

    // Кнопка вида документа "Поручение".
    @Getter
    public static SelenideElement buttonDocTypeErrand = $x("//a[text() = 'Поручение']");

    // Пользовательское меню "Обо мне".
    @Getter
    public static SelenideElement userMenu = $x("//span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    public static SelenideElement buttonExit = $x("//td[text()='Выход']");

    // Логотип АРМ.
    @Getter
    public static SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");
}



