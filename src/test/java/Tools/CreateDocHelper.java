package Tools;

import Page.CreationFormPage;
import Page.MainPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    // Метод для выбора типа документа по имени.
    public static SelenideElement typeDoc(String type) {
        switch (type) {
            case "Карточка согласования":
                return MainPage.getButtonDocTypeKS();
            case "Поручение":
                return MainPage.getButtonDocTypeErrand();
            default:
                throw new IllegalArgumentException("Неверный тип документа: " + type);
        }
    }

    // Создаем документ по выбранному типу.
    public static void createDoc(String type){
        MainPage.getButtonCreate().click();
        typeDoc(type).click();
    }

    // Вид документа, выбираем вид и элемент вида.
    public static void catalogDoc(String catalog, String el){
        CreationFormPage.getDocumentTypeCatalog(catalog).click();
        CreationFormPage.getDocumentTypeCatalogElement(el).click();
    }

    public static void setBaseFormDoc(String type){
        CreationFormPage.getDocumentCategory().click();
        CreationFormPage.getSelectCategory(type).click();
        CreationFormPage.getButtonOk_Category().click();
    }

    // Создаем документ, вид "Карточка согласования".
    public static void createApprovalCard(){
        $x("//legend[text() = 'Документы для информации']").shouldBe(visible);
        CreationFormPage.getDocumentType().click();
        catalogDoc("Прочие", "Акт");
        CreationFormPage.getButtonOk_DocType().click();
        CreationFormPage.getTitleKs().setValue("Тестовый документ");
        setBaseFormDoc("Открытый");
        sleep(2000);
    }
}
