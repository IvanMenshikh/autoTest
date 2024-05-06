package Tools;

import Page.CreationFormPage;
import Page.MainPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    CreationFormPage creationFormPage = new CreationFormPage();
    MainPage mainPage = new MainPage();

    // Метод для выбора типа документа по имени.
    public SelenideElement typeDoc(String type) {
        switch (type) {
            case "Карточка согласования":
                return mainPage.getButtonDocTypeApprovalCard();
            case "Поручение":
                return mainPage.getButtonDocTypeErrand();
            default:
                throw new IllegalArgumentException("Неверный тип документа: " + type);
        }
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        mainPage.getButtonCreate().click();
        typeDoc(type).click();
    }

    // Вид документа, выбираем вид и элемент вида.
    public void typeDocument_catalogDoc(String catalog, String el){
        creationFormPage.getDocumentTypeCatalog(catalog).click();
        creationFormPage.getDocumentTypeCatalogElement(el).click();
    }

    //Категория документа "Открытый", "ДВП", "СКХ".
    public void categoryFormDoc(String type){
        creationFormPage.getDocumentCategory().click();
        creationFormPage.getSelectCategory(type).click();
        creationFormPage.getButtonOkCategory().click();
    }

    // Создаем документ, вид "Карточка согласования".
    public void createApprovalCard(){
        $x("//legend[text() = 'Документы для информации']").shouldBe(visible);
        creationFormPage.getDocumentType().click();
        typeDocument_catalogDoc("Прочие", "Акт");
        creationFormPage.getButtonOkDocType().click();
        creationFormPage.getTitleApprovalCard().setValue("Тестовый документ");
        categoryFormDoc("Открытый");
        sleep(2000);
    }
}
