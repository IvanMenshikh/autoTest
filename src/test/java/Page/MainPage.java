package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    @Getter
    private SelenideElement buttonCreate = $x("//button[text() = 'Создать']");

    // Кнопка вида документа "Карточка согласования".
    @Getter
    private SelenideElement buttonDocTypeApprovalCard = $x("//a[text() = 'Карточка согласования']");

    // Кнопка вида документа "Поручение".
    @Getter
    private SelenideElement buttonDocTypeErrand = $x("//a[text() = 'Поручение']");

    // Пользовательское меню "Обо мне".
    @Getter
    private SelenideElement userMenu = $x("//span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    private SelenideElement buttonExit = $x("//td[text()='Выход']");

    // Логотип АРМ.
    @Getter
    private SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");



//    // Кнопка "Создать".
//    public static SelenideElement getButtonCreate(){
//        return $x("//button[text() = 'Создать']");
//    }
//
//    // Кнопка вида документа "Карточка согласования".
//    public static SelenideElement getButtonDocTypeKS(){
//        return $x("//a[text() = 'Карточка согласования']");
//    }
//
//    // Кнопка вида документа "Поручение".
//    public static SelenideElement getButtonDocTypeErrand(){
//        return $x("//a[text() = 'Поручение']");
//    }
//
//    // Пользовательское меню "Обо мне".
//    public static SelenideElement getUserMenu(){
//        return $x("//span[contains(@id,'USER_MENU')]");
//    }
//
//    // Кнопка выхода из АРМ КСЭД.
//    public static SelenideElement getExitButton(){
//        return $x("//td[text()='Выход']");
//    }
//
//    // Логотип АРМ.
//    public static SelenideElement getLogotipArm(){
//        return $x("//span[text() = 'АРМ СЭД']");
//    }

}


