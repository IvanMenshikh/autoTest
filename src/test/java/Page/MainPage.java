package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    @Getter
    private final SelenideElement buttonCreate = $x("//button[text() = 'Создать']");

    // Пользовательское меню "Обо мне".
    @Getter
    private final SelenideElement userMenu = $x("//span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    private final SelenideElement buttonExit = $x("//td[text()='Выход']");

    // Логотип АРМ.
    @Getter
    private static final SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");

    // Выбрать тип документа для создания. Создать -> выбери документ.
    public SelenideElement getDoc_Type(String type){
        return $x("//a[text() = '" + type + "']");
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        this.buttonCreate.click();
        this.getDoc_Type(type).click();
    }
}



