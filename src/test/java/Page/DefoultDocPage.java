package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DefoultDocPage {

    // Проверяем на созданном документе поле: "Категория документа".
    public SelenideElement getFieldCategoryDoc(String categoryType){
        return $x("//div[@class='main-content']//*[text()='" + categoryType + "']");
    }

    // Проверяем на созданном документе поле: "Вид документа".
    public SelenideElement getFieldDocType(String docType){
        return $x("//div[@class='main-content']//*[text()='" + docType + "']");
    }
    
    // Проверяем на созданном документе поле: "Статус".
    public SelenideElement getFieldStateMachineStatus(String stateMachine){
        return $x("//div[@class='main-content']//*[text()='" + stateMachine + "']");
    }
}
