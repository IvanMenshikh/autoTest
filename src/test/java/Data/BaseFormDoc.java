package Data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseFormDoc {
    private SelenideElement documentCategory;//Категория документа
    private SelenideElement selectDvpCategory;//Категория документа -> ДВП
    private SelenideElement buttonOk;//Кнопка Ок

    //Кнопка отмены на форме создания документа
//    private SelenideElement otmena;
//    private SelenideElement getOtmena(){
//        if(otmena == null){
//            otmena = $x("//button[contains(@id, 'default-form-cancel-button')]");
//        }
//        return otmena;
//    }

    private SelenideElement getDocumentCategory(){
        if(documentCategory == null){
            documentCategory = $x("//button[contains(@id, 'category') and text() = '...']");
        }
        return documentCategory;
    }
    private SelenideElement getSelectDvpCategory(){
        if(selectDvpCategory == null){
            selectDvpCategory = $x("//a[@id = 'alf-id2'][contains(@class, 'category')]");
        }
        return selectDvpCategory;
    }
    private SelenideElement getButtonOk(){
        if(buttonOk == null){
            buttonOk = $x("//button[contains(@id, 'category') and text() = 'OK']");
        }
        return buttonOk;
    }
    public void pasteBaseFormDoc(){
        getDocumentCategory().click();
        getSelectDvpCategory().click();
        getButtonOk().click();
    }
}
