package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class BlackBarPage {

    // КСЭД.
    @Getter
    public final SelenideElement btnKsed = $x("//div[@role='menubar']//child::a[@title='КСЭД']");

    // Поиск по ШК.
    @Getter
    public final SelenideElement btnSearchByBarcode = $x("//div[@role='menubar']//child::div[@aria-label = 'Поиск по ШК ']");

    // Еще.
    @Getter
    public final SelenideElement btnMore = $x("//div[@role='menubar']//child::div[@aria-label = 'Ещё ']");

    // Уведомления.
    @Getter
    public final SelenideElement btnNotifications = $x("//div[@role='menubar']//child::div[@aria-label = 'Уведомления ']");

    // Пользовательское меню "Обо мне".
    @Getter
    public final SelenideElement userMenu = $x("//div[@role='menubar']//child::span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    public final SelenideElement btnExit = $x("//td[text()='Выход']");

}
