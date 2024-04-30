package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionFactory;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
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
            documentType = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree-picker-button-button')]");
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
            documentTypeOtherApplication = $x("//a[contains(@id, 'alf-id2') and @title='Добавить']");
        }
        return documentTypeOtherApplication;
    }
    private SelenideElement getButtonOk(){
        if(buttonOk == null){
            buttonOk = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok-button') and text() = 'OK']");
        }
        return buttonOk;
    }

//Ожидание когда элементы станут активные(enabled) и видимые(visible)
//Используем shouldBe для проверки состояния элементов

    public void waitForClick() {
        //getDocumentType().shouldBe(Condition.visible).shouldBe(Condition.enabled);
        getDocumentTypeCollectionOther().shouldBe(Condition.enabled);
        //getDocumentTypeOtherApplication().shouldBe(Condition.visible).shouldBe(Condition.enabled);
    }

// JavaScript для клика - Использование более надежных стратегий клика

//    public void clickDocumentType() {
//        Selenide.executeJavaScript("arguments[0].click();", getDocumentType());
//    }

    public void pageLoadChecker(){
        ConditionFactory await = Awaitility.await().atMost(15, TimeUnit.SECONDS);
        await.until(() -> $x("//div[text() = 'lnd-kind-assoc-cntrl-picker_c']").is(visible));
        await.until(() -> $x("//div[text() = 'Элементы не найдены']").is(visible));
    }

    public void createKs(){
        Data.BaseFormDoc pasteBaseFormDoc = new Data.BaseFormDoc();
        getDocumentType().click();
        //pageLoadChecker();
        //waitForClick();
        getDocumentTypeCollectionOther().click();
        getDocumentTypeCollectionOther().click();
        getDocumentTypeOtherApplication().click();
        getButtonOk().click();
        getTitleKs().setValue("Тестовый документ");
        pasteBaseFormDoc.pasteBaseFormDoc();
        sleep(2000);
    }

}
