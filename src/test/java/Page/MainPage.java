package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    @Getter
    public SelenideElement btnCreate = $x("//button[text() = 'Создать']");

    // Логотип АРМ.
    @Getter
    public SelenideElement logotipArm = $x("//span[text() = 'АРМ СЭД']");

     // Блоки узлов. Моя работа, Навигатор, Отчеты и тд...
    public SelenideElement getBlock(String block){
        return $x("//div[text() = '" + block + "']");
    }

    // Выбрать тип документа для создания. Создать -> выбери документ.
    public SelenideElement getDoc_Type(String type){
        return $x("//a[text() = '" + type + "']");
    }

    // Проверка блоков. Проверяем узлы внутри блока.
    public SelenideElement getNodeBlock(String nodeBlock){
        return $x("//span[text() = '" + nodeBlock + "']");
    }

    // Атрибуты узлов. Появляются после перехода в узел.
    public SelenideElement getAtributeNode(String atributeNode){
        return $x("//button[text() = '" + atributeNode +"']");
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        this.btnCreate.click();
        this.getDoc_Type(type).click();
    }
}



