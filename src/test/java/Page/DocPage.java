package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DocPage {

    // Элемент созданного документ: "Категория документа".
    public SelenideElement getFieldCategoryDoc(String categoryDoc){
        return $x("//div[@class='main-content']//*[text()='" + categoryDoc + "']");
    }

    // Элемент созданного документ: "Вид документа".
    public SelenideElement getFieldDocType(String docType){
        return $x("//div[@class='main-content']//*[text()='" + docType + "']");
    }
    
    // Элемент созданного документ: "Статус".
    public SelenideElement getFieldStateMachineStatus(String stateMachine){
        return $x("//div[@class='main-content']//*[text()='" + stateMachine + "']");
    }
}
