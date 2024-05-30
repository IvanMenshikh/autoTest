package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DefoultDocPage {

    // Элемент созданного документ: "Категория документа".
    public SelenideElement getFieldCategoryDoc(String categoryType){
        return $x("//div[@class='main-content']//*[text()='" + categoryType + "']");
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
