package Data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class BaseFormDoc {
    private SelenideElement documentCategory;//Категория документа
    private SelenideElement selectDvpCategory;//Категория документа -> ДВП
    private SelenideElement buttonOk;//Кнопка Ок


    private SelenideElement getDocumentCategory(){
        if(documentCategory == null){
            documentCategory = $x("//button[contains(@id, 'category-assoc-cntrl-tree-picker-button-button')]");
        }
        return documentCategory;
    }
    private SelenideElement getSelectDvpCategory(){
        if(selectDvpCategory == null){
            selectDvpCategory = $x("//a[contains(@id, 'alf-id41') and @title='Добавить']");
        }
        return selectDvpCategory;
    }
    private SelenideElement getButtonOk(){
        if(buttonOk == null){
            buttonOk = $x("//button[contains(@id, 'category-assoc-cntrl-ok-button') and text() = 'OK']");//Доработать !!!
        }
        return buttonOk;
    }
    public void pasteBaseFormDoc(){
        getDocumentCategory().click();
        getSelectDvpCategory().click();
        getButtonOk().click();
    }
}
