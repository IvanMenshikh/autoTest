package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class BlockMyJobPage {

    // Блок "Моя работа".
    @Getter
    public final SelenideElement blockMyJob = $x("//div[text() = 'Моя работа']");

    // Поисковое поле в узле\подузле.
    @Getter
    public final SelenideElement fieldSearchDoc = $x("//div[@class='right ']//child::input[@type='text']");

    // Иконка "Плюс". Раскрывает узел "Созданные мной документы".
    @Getter
    public final SelenideElement ExpandNode_DocICreated = $x("//span[text() = 'Созданные мной документы']//ancestor::tr//child::td[@id = 'ygtvt30']");

    // Узел блока.
    public SelenideElement getNodeBlock(String node){
        return $x("//span[text() = '" + node + "']");
    }

    // Подузел узла.
    public SelenideElement getSubnode(String subnode){
        return $x("//span[text() = '" + subnode + "']");
    }

    // Атрибуты узлов. (фильтр, столбцы и тд...) Появляются после перехода в узел.
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



}
