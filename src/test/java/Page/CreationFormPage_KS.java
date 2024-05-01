package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreationFormPage_KS {
    private SelenideElement documentType;//Вид документа
    private SelenideElement documentTypeOther;//Вид документа -> Прочее (3 точки)
    private SelenideElement documentTypeOtherApplication;//Вид документа -> Прочее -> Акт (3 точки)
    private SelenideElement buttonOk;//Кнопка Ок
    private SelenideElement titleKs;//Заголовок

    private SelenideElement getDocumentType(){
        if(documentType == null){
            documentType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");
        }
        return documentType;
    }
    private SelenideElement getTitleKs(){
        if(titleKs == null){
            titleKs = $x("//input[@name = 'prop_lecm-document_title']");
        }
        return titleKs;
    }
    private SelenideElement getDocumentTypeCollectionOther(){
        if(documentTypeOther == null){
            documentTypeOther = $x("//span[text() = 'Прочие']");
        }
        return documentTypeOther;
    }
    private SelenideElement getDocumentTypeOtherApplication(){
        if(documentTypeOtherApplication == null){
            documentTypeOtherApplication = $x("//a[@id = 'alf-id2'][contains(@class, 'cntrlyui')]");
        }
        return documentTypeOtherApplication;
    }
    private SelenideElement getButtonOk(){
        if(buttonOk == null){
            buttonOk = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");
        }
        return buttonOk;
    }

//Ожидание когда элементы станут активные(enabled) и видимые(visible)
//Используем shouldBe для проверки состояния элементов

//    public void waitForClick() {
//        //getDocumentType().shouldBe(Condition.visible).shouldBe(Condition.enabled);
//        getDocumentTypeCollectionOther().shouldBe(Condition.enabled);
//        //getDocumentTypeOtherApplication().shouldBe(Condition.visible).shouldBe(Condition.enabled);
//    }

// JavaScript для клика - Использование более надежных стратегий клика

//    public void clickDocumentType() {
//        Selenide.executeJavaScript("arguments[0].click();", getDocumentType());
//    }

    public void createKs(){
        Data.BaseFormDoc pasteBaseFormDoc = new Data.BaseFormDoc();
        //pageLoadChecker();
        sleep(100);
        getDocumentType().click();
        //waitForClick();
        getDocumentTypeCollectionOther().click();
        getDocumentTypeCollectionOther().click();
        getDocumentTypeOtherApplication().click();
        getButtonOk().click();
        getTitleKs().setValue("Тестовый документ");
        pasteBaseFormDoc.pasteBaseFormDoc();// доработать!
        sleep(2000);
    }

}
