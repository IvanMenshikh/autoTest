package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class MainPage {

    // Кнопка "Создать".
    @Getter
    public SelenideElement buttonCreate = $x("//button[text() = 'Создать']");

    // Пользовательское меню "Обо мне".
    @Getter
    public SelenideElement userMenu = $x("//span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    public SelenideElement buttonExit = $x("//td[text()='Выход']");

    // Логотип АРМ.
    @Getter
    public static SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");

    // Выбрать тип документа для создания. Создать -> выбери документ.
    public SelenideElement getDoc_Type(String type){
        return $x("//a[text() = '" + type + "']");
    }
}



