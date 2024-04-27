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
    private SelenideElement documentCategory;//Категория документа


    private SelenideElement getDocumentType(){
        if(documentType == null){
            documentType = $x("//button[@id = 'template_x002e_content_x002e_document-create_x0023_default_assoc_rn-document-approval_document-kind-assoc-cntrl-tree-picker-button-button']");
        }
        return documentType;
    }
    private SelenideElement getTitleKs(){
        if(titleKs == null){
            titleKs = $x("//input[@name = 'prop_lecm-document_title']");
        }
        return titleKs;
    }
    private SelenideElement getDocumentCategory(){
        if(documentCategory == null){
            documentCategory = $x("//button[@id = 'template_x002e_content_x002e_document-create_x0023_default_assoc_lecm-eds-aspect_document-category-assoc-cntrl-tree-picker-button-button']");
        }
        return documentCategory;
    }
    private SelenideElement getDocumentTypeCollectionOther(){
        if(documentTypeOther == null){
            documentTypeOther = $x("//span[text() = 'Прочие']");
        }
        return documentTypeOther;
    }
    private SelenideElement getDocumentTypeOtherApplication(){
        if(documentTypeOtherApplication == null){
            documentTypeOtherApplication = $x("");//Доработать !!!
        }
        return documentTypeOtherApplication;
    }
    private SelenideElement getButtonOk(){
        if(buttonOk == null){
            buttonOk = $x("");//Доработать !!!
        }
        return buttonOk;
    }

    public void ks(){
        getDocumentType().click();
        //Не работает
        //getDocumentTypeCollectionOther().click();
        //getDocumentTypeOtherApplication().click();
        //getButtonOk().click();
        getTitleKs().setValue("Тестовый документ");
        sleep(1000);
    }

}
