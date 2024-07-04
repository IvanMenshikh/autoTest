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

    // Кнопка "Редактировать". Находится в таблице узла, где столбец действий над документами.
    @Getter
    public SelenideElement btnDocEdit = $x("//td//child::a[@title = 'Редактировать']");

    // Поле ввода номера документа в узле. Созданные мной документы.
    @Getter
    public SelenideElement fieldSearchDoc = $x("//div[@class='right ']//child::input[@type='text']");

    // Модальное окно "Загрузка...".
    @Getter
    public SelenideElement modalWindowLoading = $x("//span[text()='Загрузка...']");

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

//    // Документ в таблице.
//    public SelenideElement getDocInTable(String docNumber){
//        return $x("//td//child::a[text()='" + docNumber + "']");
//    }

    // Ищем документ в узле по номеру и статусу.
    public SelenideElement getDocByNumAndStatus(String docStatus, String docNumber){
        return $x("//div[text()='" + docStatus + "']//ancestor::tr//child::a[text()='" + docNumber + "']");
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        this.btnCreate.click();
        this.getDoc_Type(type).click();
    }
}



