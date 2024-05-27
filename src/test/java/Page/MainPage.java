package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    @Getter
    public final SelenideElement btnCreate = $x("//button[text() = 'Создать']");

    // Пользовательское меню "Обо мне".
    @Getter
    public static final SelenideElement userMenu = $x("//span[contains(@id,'USER_MENU')]");

    // Кнопка выхода из АРМ КСЭД.
    @Getter
    public final SelenideElement btnExit = $x("//td[text()='Выход']");

    // Логотип АРМ.
    @Getter
    public static final SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");

    // Поле "Навигатор".
    @Getter
    public static final SelenideElement navigator = $x("//div[text() = 'Навигатор']");

    // Выбрать тип документа для создания. Создать -> выбери документ.
    public SelenideElement getDoc_Type(String type){
        return $x("//a[text() = '" + type + "']");
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        this.btnCreate.click();
        this.getDoc_Type(type).click();
    }
}



