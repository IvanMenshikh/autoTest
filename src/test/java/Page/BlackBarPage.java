package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class BlackBarPage {

    // КСЭД.
    @Getter
    public SelenideElement btnKsed = $x("//div[@role='menubar']//child::a[@title='КСЭД']");

    // Поиск по ШК.
    @Getter
    public SelenideElement btnSearchByBarcode = $x("//div[@role='menubar']//child::div[@aria-label = 'Поиск по ШК ']");

    // Еще.
    @Getter
    public SelenideElement btnMore = $x("//div[@role='menubar']//child::div[@aria-label = 'Ещё ']");

    // Уведомления.
    @Getter
    public SelenideElement btnNotifications = $x("//div[@role='menubar']//child::div[@aria-label = 'Уведомления ']");

    // Пользовательское меню "Обо мне".
    @Getter
    public SelenideElement userMenu = $x("//div[@role='menubar']//child::span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    public SelenideElement btnExit = $x("//td[text()='Выход']");

}
