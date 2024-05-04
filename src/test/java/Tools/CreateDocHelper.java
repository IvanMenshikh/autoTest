package Tools;

import Page.MainPage;
import com.codeborne.selenide.SelenideElement;
import Page.CreationFormPage_KS;
import Object.BaseFormDoc;
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

    // Открываем форму создания по выбранному типу(String type) документа.
    public static void createFormDoc(String type){
        MainPage.getButtonCreate().click();
        typeDoc(type).click();
    }

    // Создаем документ, вид "Карточка согласования".
    public static void createApprovalCard(){
        CreationFormPage_KS.getDocumentType().click();
        CreationFormPage_KS.getDocumentTypeCatalog("Прочее").click();
        CreationFormPage_KS.getDocumentTypeCatalogElement("Акт").click();
        CreationFormPage_KS.getButtonOk().click();
        CreationFormPage_KS.getTitleKs().setValue("Тестовый документ");
        BaseFormDoc.setBaseFormDoc();
        sleep(2000);
    }
}
