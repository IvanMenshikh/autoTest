package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    @Getter
    public final SelenideElement btnCreate = $x("//button[text() = 'Создать']");

    // Логотип АРМ.
    @Getter
    public final SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");

    // Кнопка "Редактировать". Находится в таблице узла, где столбец действий над документами.
    @Getter
    public final SelenideElement btnDocEdit = $x("//td//child::a[@title = 'Редактировать']");

    // Модальное окно "Загрузка...".
    @Getter
    public final SelenideElement modalWindowLoading = $x("//span[text()='Загрузка...']");

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



